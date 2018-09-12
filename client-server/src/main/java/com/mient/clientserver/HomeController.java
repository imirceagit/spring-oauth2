package com.mient.clientserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String helloFromBaeldung() {
        return "Hello From Baeldung!";
    }

    @GetMapping("/personInfo")
    public ModelAndView person() {
        ModelAndView mav = new ModelAndView("personinfo");
        mav.addObject("person", "Mircea");
        return mav;
    }
}
