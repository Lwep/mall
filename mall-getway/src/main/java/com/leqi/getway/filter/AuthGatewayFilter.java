package com.leqi.getway.filter;

import com.alibaba.fastjson.JSON;
import com.leqi.common.constrant.GlobalConstrant;
import com.leqi.common.core.Result;
import com.leqi.common.utils.JwtUtils;
import com.leqi.common.utils.Md5Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


import java.util.List;

/**
 * @author lwep
 * @dareTime 2019/9/26 11:32
 */
@Slf4j
public class AuthGatewayFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("网关过滤器");
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        if (request.getPath().toString().contains("login")) {
            return chain.filter(exchange);
        }
        // 获取令牌
        HttpHeaders headers = request.getHeaders();
        List<String> tokens = headers.get("admin_token");
        Result result = Result.fail("没有认证");
        if (null != tokens && tokens.size() > 0) {
            String token = tokens.get(0);
            // TODO 有令牌
            if (StringUtils.isNotEmpty(token)) {
                String username = JwtUtils.getUsername(token);
                String password = Md5Utils.getMD5String(GlobalConstrant.JWT_SECRET);
                // 防篡改
                if (JwtUtils.verify(token, username, password)) {

                    //保存当前用户
                    return chain.filter(exchange);
                } else {
                    result = Result.fail("令牌不正确");
                }
            }
        }
        // 设置body
        String warningStr = JSON.toJSONString(result);
        // 响应数据
        DataBuffer bodyDataBuffer = response.bufferFactory().wrap(warningStr.getBytes());
        return response.writeWith(Mono.just(bodyDataBuffer));
    }
}
