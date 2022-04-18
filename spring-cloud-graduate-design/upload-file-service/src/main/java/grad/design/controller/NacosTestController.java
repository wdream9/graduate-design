package grad.design.controller;


import grad.design.utils.UserUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
public class NacosTestController {
    @Value("${servicename}")
    private String serviceName;

    @GetMapping("/nacos")
    public String getServiceName(){
        return serviceName;
    }
}
