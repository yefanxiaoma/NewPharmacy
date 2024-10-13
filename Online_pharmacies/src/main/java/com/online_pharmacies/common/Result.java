package com.online_pharmacies.common;

import lombok.Data;

/**
 * @author Wang
 */
@Data
public class Result {
    //编码 200/400
    private int code;
    //成功或者失败
    private String msg;
    //总记录数
    private long total;
    //数据
    private Object data;
    public static Result fail(){
        return result(400,"失败",0,null);
    }
    public static Result success() { return  result(200,"成功",0L,0L);}
    public static Result success(Object data) {return result(200,"成功",0L,data);}
    public static Result success(Object data,Long total){
        return result(200,"成功",total,data);
    }
    private static Result result(int code,String msg,long total,Object data){
        Result res = new Result();
        res.setData(data);
        res.setMsg(msg);
        res.setCode(code);
        res.setTotal(total);
        return res;
    }


}