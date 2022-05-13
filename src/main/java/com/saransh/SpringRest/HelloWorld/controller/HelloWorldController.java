package com.saransh.SpringRest.HelloWorld.controller;

import com.saransh.SpringRest.HelloWorld.bean.HelloWorldBean;
import org.springframework.web.bind.annotation.*;

@RestController //or @Controller
public class HelloWorldController {
    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public HelloWorldBean helloWorld(){
        return new HelloWorldBean("FooBar");
    }

    @GetMapping (path = "/hello-world/{paramPassed}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String paramPassed){
        return new HelloWorldBean("You passed: " + paramPassed);
    }

    @GetMapping(path = "/")
    public String defaultMapping(){
        return "Greetings from Spring Boot!";
    }
}
