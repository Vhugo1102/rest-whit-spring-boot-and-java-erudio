package br.com.vhugo1102.controllers;

import br.com.vhugo1102.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetengController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    

    //http://localhost:8080/greeting?name=Vitor
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World !!!")  String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
