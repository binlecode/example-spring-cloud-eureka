package hello;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceFailoverClient implements HelloServiceClient {
    @Override
    public String getGreeting(String name) {
        return "Hello " + name + " from backup";
    }
}
