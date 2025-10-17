package edu.xyf.wrench.dynamic.config.center.types.common;

/**
 * @Author: Xuyifeng
 * @Description:
 * @Date: 2025/10/17 15:07
 */

public class Constants {

    public final static String DYNAMIC_CONFIG_CENTER_REDIS_TOPIC = "DYNAMIC_CONFIG_CENTER_REDIS_TOPIC";

    public final static String SYMBOL_COLON = ":";

    public final static String LINE = "_";

    public static String getTopic(String application) {
        return DYNAMIC_CONFIG_CENTER_REDIS_TOPIC + application;
    }

}
