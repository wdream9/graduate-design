package grad.design.service.impl;

import grad.design.dto.LoginFormParams;
import grad.design.dto.LoginResponse;
import grad.design.entity.RegisterInfo;
import grad.design.entity.User;
import grad.design.mapper.UserMapper;
import grad.design.service.user.UserService;
import grad.design.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String name) {
        return userMapper.findByUsername(name);
    }

    @Override
    public User findUserById(int userId) {
        return userMapper.findById(userId);
    }

    @Override
    public User saveUserInfo(RegisterInfo info) {
        User user = new User();
        user.setPassword(info.getPassword());
        user.setUsername(info.getUsername());
        user.setEmail(info.getEmail());
        user.setTelephone(info.getTelephone());
        userMapper.addUser(user);
        return user;
    }
    /**
     * 验证用户登录信息
     */
    public User getUserInfo(LoginFormParams params) {
        User userInfo = this.findByUsername(params.getUsername());
        return userInfo;
    }
    /**
     *  登录验证
     */
//    public LoginResponse loginVerify(){
//        LoginResponse loginResponse = new LoginResponse();
//        User userInfo = userService.findByUsername(loginForm.getUsername());
//        if (code.equals(loginForm.getCode()) && userInfo.getPassword().equals(loginForm.getPassword())) {
//            redisTemplate.opsForHash().delete("verifyHash", ip);
//            String token = UserUtils.getToken(userInfo);
//            loginResponse.setExpireTime(expireTime);
//            loginResponse.setCode(200);
//            loginResponse.setToken(token);
//            loginResponse.setId(userInfo.getId());
//            loginResponse.setNick(userInfo.getUsername());
//            return loginResponse;
//        } else {
//            loginForm.setCode("1001");
//            return loginResponse;
//        }
//    }
}
