package com.example.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.Map;

/**
 * JWT 工具类
 */
public class Jwt {

    // 建议至少 256 bit（32 字节）的密钥
    private static final String SECRET_KEY = "mySecretKeymySecretKeymySecretKeymySecretKey";
    // Token 有效期（毫秒），这里设置 1 小时
    private static final long EXPIRE_TIME = 60 * 60 * 1000;

    // 生成签名密钥对象
    private static final Key KEY = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    /**
     * 生成 JWT 令牌
     * @param claims 要写入 JWT 的自定义数据（如用户ID、角色等）
     * @return 生成的 JWT 字符串
     */
    public static String generateJwt(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)                               // 自定义数据
                .setIssuedAt(new Date())                         // 签发时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME)) // 过期时间
                .signWith(KEY, SignatureAlgorithm.HS256)          // 签名算法
                .compact();                                       // 生成 Token
    }

    /**
     * 解析 JWT 令牌
     * @param jwt 要解析的 JWT 字符串
     * @return 解析得到的 Claims（可通过 get("key") 获取数据）
     */
    public static Claims parseJwt(String jwt) {
        return Jwts.parserBuilder()
                .setSigningKey(KEY)        // 设置签名密钥
                .build()
                .parseClaimsJws(jwt)       // 解析 Token
                .getBody();                // 获取载荷（Payload）
    }

    // 可选：简单测试
    public static void main(String[] args) {
        // 示例：创建 Map 数据
        Map<String, Object> claims = Map.of(
                "id", 1,
                "username", "admin",
                "role", "manager"
        );

        // 生成 Token
        String token = Jwt.generateJwt(claims);
        System.out.println("生成的 JWT：\n" + token);

        // 解析 Token
        Claims parsed = Jwt.parseJwt(token);
        System.out.println("\n解析结果：");
        parsed.forEach((k, v) -> System.out.println(k + " = " + v));
    }
}
