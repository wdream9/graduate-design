package grad.design;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

/**
 * @author 王远辉
 */
@EnableDubbo
@EnableDiscoveryClient
@SpringBootApplication(exclude = { FeignAutoConfiguration.class })
public class UserServiceApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplicationMain.class,args);
    }
}
