package com.wikicloud.gateway.config;

import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiDefinition;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.GatewayApiDefinitionManager;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
import com.alibaba.csp.sentinel.adapter.gateway.sc.SentinelGatewayFilter;
import com.alibaba.csp.sentinel.adapter.gateway.sc.exception.SentinelGatewayBlockExceptionHandler;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.nacos.api.PropertyKeyConst;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.result.view.ViewResolver;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Set;

@Configuration
public class GatewayConfiguration {

   private final List<ViewResolver> viewResolvers;
   private final ServerCodecConfigurer serverCodecConfigurer;

   public GatewayConfiguration(ObjectProvider<List<ViewResolver>> viewResolversProvider,
                               ServerCodecConfigurer serverCodecConfigurer) {
       this.viewResolvers = viewResolversProvider.getIfAvailable(Collections::emptyList);
       this.serverCodecConfigurer = serverCodecConfigurer;
   }

   @Bean
   @Order(Ordered.HIGHEST_PRECEDENCE)
   public SentinelGatewayBlockExceptionHandler sentinelGatewayBlockExceptionHandler() {
       // Register the block exception handler for Spring Cloud Gateway.
       return new SentinelGatewayBlockExceptionHandler(viewResolvers, serverCodecConfigurer);
   }

   @Bean
   @Order(Ordered.HIGHEST_PRECEDENCE)
   public GlobalFilter sentinelGatewayFilter() {
       return new SentinelGatewayFilter();
   }

    /**
     * 配置SentinelGatewayFilter
     * @return
     */


    @PostConstruct
    public void doInit() throws Exception {
        initGatewayRules();
    }



    /**
     * 配置限流规则  通过nacos
     */
    private void initGatewayRules() throws Exception {
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, "116.62.194.20:8848");
        properties.put(PropertyKeyConst.NAMESPACE, "wiki-dev");

        NacosDataSource<Set<GatewayFlowRule>> flowRuleDataSource = new NacosDataSource<>(properties, "SENTINEL_GROUP", "wiki-gateway-rules",
                source -> JSON.parseObject(source, new TypeReference<Set<GatewayFlowRule>>() {
                }));
        GatewayRuleManager.register2Property(flowRuleDataSource.getProperty());

        NacosDataSource<Set<ApiDefinition>> apiNacosDataSource = new NacosDataSource<>(properties, "SENTINEL_GROUP", "wiki-gateway-api",
                source -> JSON.parseObject(source, new TypeReference<Set<ApiDefinition>>() {
                }));
        GatewayApiDefinitionManager.register2Property(apiNacosDataSource.getProperty());
    }

//    @Bean
//    public Converter<List<ApiDefinitionEntity>, String> apiDefinitionEntityEncoder() {
//        return JSON::toJSONString;
//    }
}