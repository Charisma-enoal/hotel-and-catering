package com.murphy.gee.sys.controller;

import com.murphy.gee.common.entity.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Base64;
import java.util.Collections;

/**
 * @ClassName LoginController
 * @Description 登录控制器
 * @Author Murphy.Gee
 * @Date 2019-07-26 15:17
 * @Version 1.0
 **/
@RestController
public class LoginController {
    @Autowired
    private OAuth2ClientProperties oAuth2ClientProperties;
    @Autowired
    private OAuth2ProtectedResourceDetails oAuth2ProtectedResourceDetails;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ResourceLoader resourceLoader;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @PostMapping("/login")
    @ResponseBody
    public JsonResult<ResponseEntity<OAuth2AccessToken>> login(String username, String password){
        String client_secret = oAuth2ClientProperties.getClientId()+":"+oAuth2ClientProperties.getClientSecret();
        client_secret = "Basic "+ Base64.getEncoder().encodeToString(client_secret.getBytes());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization",client_secret);

        //授权请求信息
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.put("username", Collections.singletonList(username));
        map.put("password", Collections.singletonList(password));
        map.put("grant_type", Collections.singletonList(oAuth2ProtectedResourceDetails.getGrantType()));

        map.put("scope", oAuth2ProtectedResourceDetails.getScope());
        //HttpEntity
        HttpEntity httpEntity = new HttpEntity(map,httpHeaders);
        ResponseEntity<OAuth2AccessToken> responseEntity = restTemplate.exchange(oAuth2ProtectedResourceDetails.getAccessTokenUri(), HttpMethod.POST,httpEntity, OAuth2AccessToken.class);
        //获取 Token
        return new JsonResult<>().success(responseEntity);
    }
    @GetMapping("/test")
    public String test(HttpServletResponse response){
        Resource resource = resourceLoader.getResource("classpath:public.cert");
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try{
            File file = resource.getFile();
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + resource.getFilename());// 设置文件名
            byte[] buffer = new byte[1024];
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            OutputStream os = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
            return "下载成功";
        }catch (IOException ex){
            ex.printStackTrace();
        }finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return "下载失败";
    }
}
