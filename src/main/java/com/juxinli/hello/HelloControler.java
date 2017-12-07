package com.juxinli.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ivy on 2017/11/30.
 */
@RestController
public class HelloControler {

    @RequestMapping("/hello")
    public String index(){
        return "hello world ";
    }

}
