package com.mad.mad.application.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class RootController {

    static class Welcome {
        private String name;

        public String getName() {
            String greeting_message = "hello";
            return greeting_message + " " + this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @GetMapping("/")
    @ResponseBody
    public Welcome init(@RequestParam("name") String name) {
        Welcome welcome = new Welcome();
        welcome.setName(name);
        return welcome;
    }


}
