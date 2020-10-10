package com.wikicloud.userapi.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "sys_config")
public class Test {

    String variable;

    String value;

    Date setTime;

    Long setBy;

    Long id;
}
