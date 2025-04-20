package com.service.rest.restFul_web_service.Controller;

import com.service.rest.restFul_web_service.Config.HelloWorldBean;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping ("/hello")
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String getHelloWorld(){
        return "helloWorld";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean getHelloWorldBean(){
        return new HelloWorldBean("Hello-World-bean-method");
    }

    @GetMapping("/hello-world-bean/path/{name}")
    public HelloWorldBean getHelloWorldBeanParam(@PathVariable String name){
        return new HelloWorldBean(name);
    }
}
