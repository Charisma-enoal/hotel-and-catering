package com.murphy.gee.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Arrays;
import java.util.Collections;

/**
 * @ClassName Swagger2Config
 * @Description Swagger2配置
 * @Author Murphy.Gee
 * @Date 2019-08-27 11:36
 * @Version 1.0
 **/
@Configuration
@EnableSwagger2
public class Swagger2Config {

    //认证服务器地址
    @Value("${auth_server}")
    private String AUTH_SERVER;

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //扫描的包路径
                .apis(RequestHandlerSelectors.basePackage("com.murphy.gee"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(Collections.singletonList(securityScheme()))
                .securityContexts(Collections.singletonList(securityContext()));
    }

    @Bean
    public SecurityConfiguration securityConfiguration(){
        return SecurityConfigurationBuilder.builder()
                .clientId("murphy")
                .clientSecret("123456")
                .scopeSeparator(",")
                .useBasicAuthenticationWithAccessCodeGrant(true)
                .build();
    }

    private SecurityScheme securityScheme(){
        GrantType grantType = new ResourceOwnerPasswordCredentialsGrant(AUTH_SERVER + "/oauth/token");
        SecurityScheme oauth = new OAuthBuilder().name("swagger_oauth")
                .grantTypes(Collections.singletonList(grantType))
                .scopes(Arrays.asList(scopes()))
                .build();
        return oauth;
    }

    private SecurityContext securityContext(){
        return SecurityContext.builder()
                .securityReferences(Arrays.asList(new SecurityReference("swagger_oauth", scopes())))
                .forPaths(PathSelectors.ant("/api/**"))
                .build();
    }
    private AuthorizationScope[] scopes(){
        return new AuthorizationScope[]{
                new AuthorizationScope("read","read"),
                new AuthorizationScope("write","wirte")
        };
    }

    /*
     * @description: 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
     * @param
     * @return: springfox.documentation.service.ApiInfo
     * @author: Murphy.Gee
     * @date: 2019-08-27 11:43
     */
    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                //页面标题
//                .title("API 文档")
//                //创建人
//                .contact(new Contact("Murphy.Gee", "http://www.murphy.com", "a359009471@gmail.com"))
//                //版本号
//                .version("1.0")
//                //描述
//                .description("此文档适用于本系统")
//                .build();
        return new ApiInfo("当前系统的API文档",
                "此文档适用于本系统",
                "1.0",
                "",
                new Contact("Murphy.Gee","http://www.murphy.com", "a359009471@gmail.com"),
                "",
                "",
                Collections.emptyList()
        );
    }
}
