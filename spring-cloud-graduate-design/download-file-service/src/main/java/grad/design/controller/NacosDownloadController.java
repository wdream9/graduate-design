package grad.design.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosDownloadController {
    @Value("${servicename}")
    private String serviceName;

    @GetMapping("/nacos")
    public String getServiceName(){
        return serviceName;
    }
}
