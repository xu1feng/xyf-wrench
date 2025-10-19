package edu.xyf.wrench.rate.limiter.config;

import edu.xyf.wrench.rate.limiter.aop.RateLimiterAOP;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Xuyifeng
 * @Description: 限流配置
 * @Date: 2025/10/19 21:13
 */
@Configuration
public class RateLimiterAutoConfig {

    @Bean
    public RateLimiterAOP rateLimiterAOP() {
        return new RateLimiterAOP();
    }

}
