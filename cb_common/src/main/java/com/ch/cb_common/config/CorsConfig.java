
package com.ch.cb_common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


/**
 * 解决跨域问题
 */

//@Configuration
public class CorsConfig {
    private org.springframework.web.cors.CorsConfiguration buildConfig() {
        org.springframework.web.cors.CorsConfiguration corsConfiguration = new org.springframework.web.cors.CorsConfiguration();
        // 允许任何的head头部
        corsConfiguration.addAllowedHeader("*");
        // 允许任何域名使用
        corsConfiguration.addAllowedOrigin("*");
        // 允许任何的请求方法
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }


/**
     * 添加CorsFilter拦截器，对任意的请求使用
     *
     * @return
     */

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }
}

