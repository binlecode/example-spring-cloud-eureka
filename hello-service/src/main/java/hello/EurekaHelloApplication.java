package hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@EnableSwagger2
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaHelloApplication.class, args);
    }

}

/*
 * We’ll see the eureka-client registered under whatever name you specify in the spring.application.name property.
 * This property is used in service bootstrap, by convention in bootstrap.properties file.
 */

@RestController
class ServiceInstanceRestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service-instance/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName
    ) {
        return discoveryClient.getInstances(applicationName);
    }

}


@RestController
class HelloServiceController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/hello/{name}")
    public String greet(
            @PathVariable String name
    ) {
        return "hello " + name + " from cloud service with port " + serverPort;
    }

}


