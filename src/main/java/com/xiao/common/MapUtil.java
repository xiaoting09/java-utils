package com.xiao.common;

import java.util.Map;

/**
 * Map操作工具类
 *
 * @author 肖亭
 * @since 2017年11月25 17:43
 **/
public class MapUtil {
    /**
     * 构造器.
     */
    private MapUtil() {
    }

    /**
     * 判断Map集合是否为空.
     * 为空返回true  不为空返回false.
     *
     * @param map 请求的Map.
     * @param <K> key类型.
     * @param <V> value类型.
     * @return true/false.
     */
    public static <K, V> boolean isNull(Map<K, V> map) {
        return map == null || map.isEmpty();
    }

    /**
     * 判断Map集合不为空.
     * 不为空返回true，为空返回false.
     *
     * @param map 请求的参数.
     * @param <K> key.
     * @param <V> value.
     * @return true/false.
     */
    public static <K, V> boolean isNotNull(Map<K, V> map) {
        return !isNull(map);
    }
}
