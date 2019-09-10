package com.murphy.gee.sys.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @ClassName ResourceServerConfiguration
 * @Description 资源服务配置
 * @Author Murphy.Gee
 * @Date 2019-07-22 17:19
 * @Version 1.0
 **/
@Configuration
@EnableResourceServer
//开启方法安全性注解，prePostEnabled 使用表达式时间方法级别的安全性
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    @Autowired
    @Qualifier("tokenStore")
    private TokenStore tokenStore;

    /**
     *@Description 配置HTTP验证规则
     *@Param [http]
     *@Return void
     *@Author Murphy.Gee
     *@Date 2019-02-26
     *@Time 11:19
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/trace/users/**",
                        "/webjars/**",
                        "/webjars/springfox-swagger-ui/**",
                        "/resources/**",
                        "/swagger-ui.html",
                        "/swagger-resources/**",
                        "/v2/api-docs","/css/**","/img/**","/js/**","/semantic/**")
                .permitAll()
                .and().authorizeRequests().antMatchers(HttpMethod.OPTIONS,"/oauth/**").permitAll()
                .and().authorizeRequests().antMatchers("/login","/test").permitAll()
                .anyRequest()
                .authenticated();
    }


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
