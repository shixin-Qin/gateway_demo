package com.example.gateway_service.configuration;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * 限流策略类
 *
 * @author qinshixin
 * @version 1.0.0
 * @createTime 2021/12/1 18
 */
@Configuration
public class ReteLimiterBeans {
    
    /**
     * ip限流
     *
     * @return
     */
    @Bean
    public KeyResolver hostAddrKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }
    
    /**
     * 用户限流
     *
     * @return
     */
    // @Bean
    public KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getHeaders().getFirst("Authorization"));
    }
    
    /**
     * 接口限流
     *
     * @return
     */
    // @Bean
    KeyResolver apiKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getPath().value());
    }
    
}
