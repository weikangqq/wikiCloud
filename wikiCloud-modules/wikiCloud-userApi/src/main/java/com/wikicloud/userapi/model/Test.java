package com.wikicloud.userapi.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "test")
public class Test {

    String name;

    Long id;
}
