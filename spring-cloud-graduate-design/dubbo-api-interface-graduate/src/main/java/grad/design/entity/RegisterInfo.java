package grad.design.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class RegisterInfo implements Serializable {
    private String username;
    private String password;
    private String code;
    private String telephone;
    private String email;
}
