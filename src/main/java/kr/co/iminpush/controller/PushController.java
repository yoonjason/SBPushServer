package kr.co.iminpush.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PushController {

    @RequestMapping(value = "/push")
    public String push(){
        return "index.html";
    }


}
