package com.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;

/**
 * ClassName: SecurityConfigTest
 * Package: com.backend.config
 * Descirption:
 *
 * @Author QLM
 * @Create 2023/11/2 20:49
 * @Version 1.0
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;

    /*
    * 为方便测试接口，先放行所有请求
    * */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/user/**").permitAll()
                .and()
                .csrf().disable();
        http.formLogin()//自定义自己编写的登录页面
                .loginPage("/login.html")//登录页面设置
                .usernameParameter("username").passwordParameter("password")
                .loginProcessingUrl("/user/login")//登录访问路径
                .defaultSuccessUrl("/user")   //登陆成功后默认重定向地址
                .and()
            .logout()
                .logoutUrl("/user/logout")
                .logoutSuccessUrl("/logout.html");
/*               TODO video模块需要测试展示全部放行 后期记得配置好
                .antMatchers("/video/**","/test/hello","/user/login").permitAll()//设置哪些路径可以直接访问，不需要认证
                //当前登录用户，只有具有admins权限才可以访问
                .antMatchers("/test/index").hasAuthority("admins")
                .anyRequest().authenticated()
                .and().csrf().disable();//关闭csrf防护*/
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
