package com.example;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class Demo2ApplicationTests {

    @Test
    void contextLoads() {
        // 1. 生成签名密钥（必须够长，否则会报错）
        Key key = Keys.hmacShaKeyFor("mySecretKeymySecretKeymySecretKeymySecretKey".getBytes());
        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        map.put("age",18);
        // 3. 生成 JWT
        String jwt = Jwts.builder()
                .setClaims(map)                 // 把 Map 数据写入 Payload
                .setSubject("userToken")           // Token 的主题（可选）
                .setIssuedAt(new Date())           // 签发时间
                .setExpiration(new Date(System.currentTimeMillis() + 3600_000)) // 1小时有效
                .signWith(key, SignatureAlgorithm.HS256)  // 使用 HS256 签名算法
                .compact();

        System.out.println("生成的 JWT：");
        System.out.println(jwt);
        // 4. 解析 JWT
        Map<String, Object> parsedClaims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt)
                .getBody();

        System.out.println("\n解析后的数据：");
        System.out.println(parsedClaims);
    }

}
