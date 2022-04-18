package grad.design.utils;

import cn.hutool.system.UserInfo;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import grad.design.entity.User;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserUtils {
    //设置30分钟过期
    @Value("${expireTime}")
    private static long EXPIRE_DATE;
    //token秘钥
    @Value("${tokenSecret}")
    private static final String TOKEN_SECRET = "EQIUBFKSJBFJH2367816BQWE";

    /**
     * 生成加密 token
     */
    public static String getToken(User userInfo) {

        String token = "";
        try {
            //过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_DATE);
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String, Object> header = new HashMap<>();
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            //携带username，password信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("username", userInfo.getUsername())
                    .withClaim("userId", userInfo.getId())
                    .withClaim("password", userInfo.getPassword()).withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return token;
    }

    /**
     * token 解密
     *
     * @param token
     * @return
     */
    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取用户真实 ip 地址
     */
    public static String getIPAddress(HttpServletRequest request) {
        String ip = null;
        String ipAddresses = request.getHeader("X-Forwarded-For");

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //Proxy-Client-IP：apache 服务代理
            ipAddresses = request.getHeader("Proxy-Client-IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //WL-Proxy-Client-IP：weblogic 服务代理
            ipAddresses = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //HTTP_CLIENT_IP：有些代理服务器
            ipAddresses = request.getHeader("HTTP_CLIENT_IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //X-Real-IP：nginx服务代理
            ipAddresses = request.getHeader("X-Real-IP");
        }

        //有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
        if (ipAddresses != null && ipAddresses.length() != 0) {
            ip = ipAddresses.split(",")[0];
        }

        //还是不能获取到，最后再通过request.getRemoteAddr();获取
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
