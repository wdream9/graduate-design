package grad.design.service.dubbo;

import grad.design.entity.RegisterInfo;
import grad.design.entity.User;
import grad.design.mapper.UserMapper;
import grad.design.service.user.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 王远辉
 */
//@Service
public class UserDubboImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUsername(String name) {
       return null;
    }

    @Override
    public User findUserById(int userId) {
        User user = new User();
        user.setId(userId);
        user.setUsername("wyh");
        return userMapper.findById(userId);
    }

    @Override
    public User saveUserInfo(RegisterInfo info) {
        return null;
    }
}
