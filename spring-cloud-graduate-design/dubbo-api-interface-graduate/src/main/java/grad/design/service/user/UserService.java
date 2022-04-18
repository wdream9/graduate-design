package grad.design.service.user;

import grad.design.entity.RegisterInfo;
import grad.design.entity.User;

public interface UserService {

    /**
     * 姓名查询用户信息
     *
     * @param name
     * @return
     */
    User findByUsername(String name);

    /**
     * 用户id查询用户信息
     *
     * @param userId
     * @return
     */
    User findUserById(int userId);

    /**
     * 注册用户，保存用户信息
     */
    User saveUserInfo(RegisterInfo info);

}
