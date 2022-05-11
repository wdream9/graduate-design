package grad.design;


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 王远辉
 */
@EnableDubbo
@EnableDiscoveryClient
@SpringBootApplication
public class DownloadApplication {
    public static void main(String[] args) {
        SpringApplication.run(DownloadApplication.class,args);
    }
}
