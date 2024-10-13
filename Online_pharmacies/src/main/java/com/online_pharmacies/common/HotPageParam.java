package com.online_pharmacies.common;

import lombok.Data;

import java.util.HashMap;

/**
 * @author Wang
 */
@Data
public class HotPageParam {
    private static int Hot_SIZE=20;
    private static int Hot_NUM=1;

    private int hotSize = Hot_SIZE;
    private int hotNum = Hot_NUM;
    private HashMap<Object, Object> param = new HashMap<>();
}
