package hello;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * Feign是一个声明式Web Service客户端。使用Feign能让编写Web Service客户端更加简单,
 * 它的使用方法是定义一个接口，然后在上面添加注解，同时也支持JAX-RS标准的注解。
 * Feign也支持可拔插式的编码器和解码器。
 * Spring Cloud对Feign进行了封装，使其支持了Spring MVC标准注解和HttpMessageConverters。
 * Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果。整合了Hystrix，具有熔断的能力
 *
 * 使用Feign，只需要创建一个接口并注解。它具有可插拔的注解特性.
 *
 * Feign是自带断路器(Hystrix)的，在D版本的Spring Cloud之后，它没有默认打开。需要在配置文件中配置打开它，在配置文件加以下代码
 * feign.hystrix.enabled=true (application.yml)
 */
@FeignClient(name = "hello-service", fallback = HelloServiceFailoverClient.class)  // name:远程服务名，aka cloud service app's spring.application.name value
public interface HelloServiceClient {

    @GetMapping("/hello/{name}")
    String getGreeting(@PathVariable String name);

}
