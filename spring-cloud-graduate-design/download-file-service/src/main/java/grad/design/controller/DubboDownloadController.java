package grad.design.controller;


import grad.design.entity.User;
import grad.design.service.user.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

/**
 * @author 王远辉
 */
@RestController
@RequestMapping("/hdfs")
@CrossOrigin
public class DubboDownloadController {
    @Reference
    private UserService userService;

    @GetMapping("/user/{id}")
    public String dubboDown(@PathVariable("id") Integer id){
        User user = userService.findUserById(id);
        return user.toString();
    }
}
