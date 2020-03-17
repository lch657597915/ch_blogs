
package com.ch.cb_eureka.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * -------------------------------------------------
 *
 * @ProjectName : system
 * @Descprition : TODO
 * @Author : fengzijk
 * @email: guozhifengvip@163.com
 * @Time : 2019/3/6 15:12
 * --------------------------------------------------
 */
@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/eureka/**");
        super.configure(http);
    }
}




