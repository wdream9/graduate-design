package grad.design.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LoginFormParams {
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 验证码
     */
    private String code;
}
