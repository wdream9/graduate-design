package grad.design.dto;


import lombok.Data;

@Data
public class LoginResponse {
    /**
     * 状态码
     */
    private int code;
    /**
     * 登录token
     */
    private String token;
    /**
     * 用户 id
     */
    private int id;
    /**
     * token过期时间
     */
    private int expireTime;
    /**
     * 用户昵称
     */
    private String nick;
}
