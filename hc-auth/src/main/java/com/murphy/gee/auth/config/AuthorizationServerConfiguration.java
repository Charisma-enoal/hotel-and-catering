package com.murphy.gee.auth.config;

import com.murphy.gee.auth.service.AuthUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.sql.DataSource;

/**
 * @ClassName AuthorizationServerConfiguration
 * @Description 配置客户端详情、授权端点、安全约束等
 * @Author Murphy.Gee
 * @Date 2019-07-22 10:29
 * @Version 1.0
 **/
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;
    @Autowired
    private ClientDetailsService myClientDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;
    @Autowired
    private TokenStore tokenStore;
    @Autowired
    private AuthUserDetailsService authUserDetailsService;

    /*
     * @description: 从数据库加载客户端
     * @param
     * @return: org.springframework.security.oauth2.provider.ClientDetailsService
     * @author: Murphy.Gee
     * @date: 2019-07-22 11:36
     */
    @Bean
    public ClientDetailsService myClientDetailsService() {
        return new JdbcClientDetailsService(dataSource);
    }

    /*
     * @description: JWT
     * @param
     * @return: org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
     * @author: Murphy.Gee
     * @date: 2019-07-22 11:48
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("murphy-jwt.jks"), "murphy666666".toCharArray());
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setKeyPair(keyStoreKeyFactory.getKeyPair("murphy-jwt"));
        return converter;
    }

    /*
     * @description: token存储
     * @param
     * @return: org.springframework.security.oauth2.provider.token.TokenStore
     * @author: Murphy.Gee
     * @date: 2019-07-22 11:47
     */
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter);
    }

    /*
     * @description: 配置客户端详情服务
     * @param clients
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-07-22 10:50
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource);
    }

    /*
     * @description: 校验端点设置
     * @param endpoints
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-07-22 11:47
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore).tokenEnhancer(jwtAccessTokenConverter).authenticationManager(authenticationManager).userDetailsService(authUserDetailsService);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //允许表单认证
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()").allowFormAuthenticationForClients();
    }
}
