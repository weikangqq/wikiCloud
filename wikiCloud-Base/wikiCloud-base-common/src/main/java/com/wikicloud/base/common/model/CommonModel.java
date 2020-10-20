package com.wikicloud.base.common.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CommonModel implements Serializable {

    private Date createDate;

    private Date updateDate;

    private Long createrId;

    private Long updaterId;

    private String createrName;

    private String updaterName;

    private Boolean ifDel;

}
