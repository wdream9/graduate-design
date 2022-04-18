package grad.design;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 王远辉
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplicationRun {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplicationRun.class,args);
    }
}
