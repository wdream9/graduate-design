package grad.design.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.core.util.ObjectUtil;
import grad.design.dto.LoginFormParams;
import grad.design.dto.LoginResponse;
import grad.design.entity.RegisterInfo;
import grad.design.entity.User;
import grad.design.service.hdfs.HdfsService;
import grad.design.service.user.UserService;
import grad.design.utils.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/user")
@CrossOrigin
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Value("${expireTime}")
    private int expireTime;

    /**
     * 验证码流返回给客户端
     */
    @GetMapping("/code")
    public void getVerifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ip = UserUtils.getIPAddress(request);
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(145, 32, 4, 4);
        response.setContentType("arraybuffer");
        captcha.write(response.getOutputStream());
        String code = captcha.getCode();
        log.info(code);
        redisTemplate.opsForHash().put("verifyHash", ip, code);
    }

    /**
     * 用户注册
     */
    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterInfo registerInfo, HttpServletRequest request) {
        String ip = UserUtils.getIPAddress(request);
        String code = (String) redisTemplate.opsForHash().get("verifyHash", ip);
        if (code.equals(registerInfo.getCode())) {
            redisTemplate.opsForHash().delete("verifyHash", ip);
            User byUsername = userService.findByUsername(registerInfo.getUsername());
            if (ObjectUtil.isEmpty(byUsername)) {
                User userInfo = userService.saveUserInfo(registerInfo);
                return userInfo != null ? "00000" : "10004";
            } else {
                return "10005";
            }
        } else {
            return "10006";
        }
    }

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public LoginResponse userLogin(@RequestBody LoginFormParams loginForm, HttpServletRequest request) {
        String ip = UserUtils.getIPAddress(request);
        String code = (String) redisTemplate.opsForHash().get("verifyHash", ip);
        LoginResponse loginResponse = new LoginResponse();
        User userInfo = userService.findByUsername(loginForm.getUsername());
        if (code.equals(loginForm.getCode()) && userInfo.getPassword().equals(loginForm.getPassword())) {
            redisTemplate.opsForHash().delete("verifyHash", ip);
            String token = UserUtils.getToken(userInfo);
            loginResponse.setExpireTime(expireTime);
            loginResponse.setCode(200);
            loginResponse.setToken(token);
            loginResponse.setId(userInfo.getId());
            loginResponse.setNick(userInfo.getUsername());
            return loginResponse;
        } else {
            loginForm.setCode("1001");
            return loginResponse;
        }
    }
}
