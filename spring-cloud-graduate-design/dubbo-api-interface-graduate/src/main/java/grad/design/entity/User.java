package grad.design.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    /**
     * 用户id
     */
    private int id;
    /**
     * 用户名称
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String telephone;
}
