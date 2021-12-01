package com.example.gateway_service.configuration;

import com.example.gateway_service.filter.TokenFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 过滤器配置
 *
 * @author qinshixin
 * @version 1.0.0
 * @createTime 2021/12/1 11
 */
@Configuration
@Slf4j
public class GatewayRoutesConfiguration {
    
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes().route(r -> r.path("/gateway-home/service-demo2/**")
                .filters(f -> f.stripPrefix(1).filters(new TokenFilter())).uri("lb://service-demo-8002")).build();
    }
    
}
