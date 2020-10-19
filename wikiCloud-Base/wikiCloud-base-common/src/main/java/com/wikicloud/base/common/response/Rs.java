package com.wikicloud.base.common.response;


import lombok.Data;

@Data
public class Rs<T> {

    String code;

    String msg;

    Boolean result;

    T data;


    public static Rs success(Object t){
        Rs rs=new Rs();
        rs.setCode("200");
        rs.setResult(true);
        rs.setData(t);
        return rs;
    }

    public static Rs failed(Object t){
        Rs rs=new Rs();
        rs.setCode("100");
        rs.setResult(false);
        rs.setData(t);
        return rs;
    }

}
