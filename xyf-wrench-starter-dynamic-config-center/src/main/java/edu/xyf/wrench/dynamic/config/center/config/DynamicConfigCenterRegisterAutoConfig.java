package edu.xyf.wrench.dynamic.config.center.config;

import edu.xyf.wrench.dynamic.config.center.domain.model.valobj.AttributeVO;
import edu.xyf.wrench.dynamic.config.center.domain.service.DynamicConfigCenterService;
import edu.xyf.wrench.dynamic.config.center.domain.service.IDynamicConfigCenterService;
import edu.xyf.wrench.dynamic.config.center.listener.DynamicConfigCenterAdjustListener;
import edu.xyf.wrench.dynamic.config.center.types.common.Constants;
import org.redisson.Redisson;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @Author: Xuyifeng
 * @Description:
 * @Date: 2025/10/17 15:12
 */
@Configuration
@EnableConfigurationProperties(value = {DynamicConfigCenterAutoProperties.class,
        DynamicConfigCenterRegisterAutoConfigProperties.class})
public class DynamicConfigCenterRegisterAutoConfig {

    private final Logger log = LoggerFactory.getLogger(DynamicConfigCenterRegisterAutoConfig.class);

    @Bean("xyfWrenchRedissonClient")
    public RedissonClient redissonClient(DynamicConfigCenterRegisterAutoConfigProperties properties) {
        Config config = new Config();
        // 根据需要可以设定编解码器；https://github.com/redisson/redisson/wiki/4.-%E6%95%B0%E6%8D%AE%E5%BA%8F%E5%88%97%E5%8C%96
        config.setCodec(JsonJacksonCodec.INSTANCE);

        config.useSingleServer()
                .setAddress("redis://" + properties.getHost() + ":" + properties.getPort())
                .setPassword(properties.getPassword())
                .setConnectionPoolSize(properties.getPoolSize())
                .setConnectionMinimumIdleSize(properties.getMinIdleSize())
                .setIdleConnectionTimeout(properties.getIdleTimeout())
                .setConnectTimeout(properties.getConnectTimeout())
                .setRetryAttempts(properties.getRetryAttempts())
                .setRetryInterval(properties.getRetryInterval())
                .setPingConnectionInterval(properties.getPingInterval())
                .setKeepAlive(properties.isKeepAlive())
        ;

        RedissonClient redissonClient = Redisson.create(config);

        log.info("xyf-wrench，注册器（redis）链接初始化完成。{} {} {}", properties.getHost(), properties.getPoolSize(), !redissonClient.isShutdown());

        return redissonClient;
    }

    @Bean
    public IDynamicConfigCenterService dynamicConfigCenterService(DynamicConfigCenterAutoProperties dynamicConfigCenterAutoProperties, RedissonClient xyfWrenchRedissonClient) {
        return new DynamicConfigCenterService(dynamicConfigCenterAutoProperties, xyfWrenchRedissonClient);
    }

    @Bean
    public DynamicConfigCenterAdjustListener dynamicConfigCenterAdjustListener(IDynamicConfigCenterService dynamicConfigCenterService) {
        return new DynamicConfigCenterAdjustListener(dynamicConfigCenterService);
    }

    @Bean
    public RTopic dynamicConfigCenterRedisTopic(DynamicConfigCenterAutoProperties dynamicConfigCenterAutoProperties, RedissonClient xyfWrenchRedissonClient, DynamicConfigCenterAdjustListener dynamicConfigCenterAdjustListener) {
        RTopic topic = xyfWrenchRedissonClient.getTopic(Constants.getTopic(dynamicConfigCenterAutoProperties.getSystem()));
        topic.addListener(AttributeVO.class, dynamicConfigCenterAdjustListener);
        return topic;
    }

}
