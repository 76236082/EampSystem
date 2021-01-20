package com.nifei.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nifei.bean.User;
import com.nifei.service.UserService;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserTest {

    @Autowired
    UserService userService;

    // jackson转换工具
    private static final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    @Test
    public void testLogin(){
        userService.Loigin(new User("admin","123"));
    }

    @Test
    public void test01() throws IOException {
        HttpClient client = new org.apache.commons.httpclient.HttpClient();

        String saasUrl = "http://localhost:8080/login";

        String apiKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1cGRhdGVfdGltZSI6IjIwMTktMTItMzEgMTA6MTk6MDciLCJ1c2VybmFtZSI6InFpbmppYW5xaXUiLCJ1c2VyX2lkIjoxNjYsImV4cCI6NzI1ODA4OTYwMH0.y9VnJCeIyB2bwjf28U3x-ONKFY4uqmbCRz52UP_YQRs";
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("username", "admin");
        dataMap.put("password", "123");

        PostMethod method = new PostMethod(saasUrl);
        method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");// 设置编码方式

        String s = objectMapper.writeValueAsString(dataMap);
        System.err.println(s);
        method.setRequestEntity(new StringRequestEntity(s,"application/json","utf-8"));
//        NameValuePair[] data = { new NameValuePair("username", "admin"),new NameValuePair("password", "123")};
//        method.setRequestBody(data);
        client.executeMethod(method);
        String result = method.getResponseBodyAsString();
        System.err.println("________________");
        System.out.println(result);
        System.err.println("________________");
    }

}
