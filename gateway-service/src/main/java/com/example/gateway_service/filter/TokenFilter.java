package com.example.gateway_service.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * 增加参数过滤器
 *
 * @author qinshixin
 * @version 1.0.0
 * @createTime 2021/12/1 11
 */
@Slf4j
public class TokenFilter implements GatewayFilter, Ordered {
    
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String authorization = exchange.getRequest().getHeaders().getFirst("Authorization");
        log.info("TokenFilter:{}", authorization);
        if (authorization == null) {
            return errorInfo(exchange, "认证不通过", 20002);
        }
        return chain.filter(exchange);
    }
    
    @Override
    public int getOrder() {
        return 0;
    }
    
    /**
     * 返回response
     *
     * @param exchange
     * @param message  异常信息
     * @param status   data中的status
     * @return
     */
    public static Mono<Void> errorInfo(ServerWebExchange exchange, String message, Integer status) {
        // 自定义返回格式
        Map<String, Object> resultMap = new HashMap<>(8);
        resultMap.put("status", status == null ? 2 : status);
        resultMap.put("message", StringUtils.isBlank(message) ? "服务异常！" : message);
        resultMap.put("info", null);
        resultMap.put("data", null);
        return Mono.defer(() -> {
            byte[] bytes = new byte[0];
            try {
                bytes = new ObjectMapper().writeValueAsBytes(resultMap);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            ServerHttpResponse response = exchange.getResponse();
            response.getHeaders().add("Content-Type", MediaType.APPLICATION_JSON_UTF8.toString());
            DataBuffer buffer = response.bufferFactory().wrap(bytes);
            return response.writeWith(Flux.just(buffer));
        });
    }
    
}
