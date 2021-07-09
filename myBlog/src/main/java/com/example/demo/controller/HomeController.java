
//package com.example.demo.controller;
//
//import org.springframework.stereotype.Controller;
//
//import javax.annotation.Resource;
//
//@Controller
//public class HomeController {
//@Resource
//    private
//
//}

package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/Home")
    public String home(){
        return "";
    }

}

