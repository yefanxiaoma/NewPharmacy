package com.online_pharmacies.common;

import lombok.Data;

import java.util.HashMap;
/**
 * @author Wang
 */
@Data
public class QueryPageParam {
    private static int PAGE_SIZE=20;
    private static int PAGE_NUM=1;

    private int pageSize = PAGE_SIZE;
    private int pageNum = PAGE_NUM;
    private HashMap<Object, Object> param = new HashMap<>();
}

