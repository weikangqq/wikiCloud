package com.wikicloud.base.shardingjdbc.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.apache.shardingsphere.shardingjdbc.spring.boot.SpringBootConfiguration;

import javax.sql.DataSource;
import java.sql.SQLException;

@EnableTransactionManagement
@Configuration
@MapperScan("com.wikicloud.user.server.mapper")
public class MybatisPlusConfig {

    @Autowired
    SpringBootConfiguration springBootConfiguration;
    /**
     * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> configuration.setUseDeprecatedExecutor(false);
    }

        @Bean
    public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean() throws SQLException {
        MybatisSqlSessionFactoryBean mysqlplus = new MybatisSqlSessionFactoryBean();
        mysqlplus.setDataSource(springBootConfiguration.shardingDataSource());
        return mysqlplus;
    }

    @Bean
    public DataSource masterSlaveDataSource() throws SQLException {
        return springBootConfiguration.shardingDataSource();
    }

}
