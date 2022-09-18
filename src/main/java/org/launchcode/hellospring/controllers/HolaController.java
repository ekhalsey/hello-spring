package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HolaController {

    @GetMapping("greetForm")
    @ResponseBody //returns plain text response, wont use once there are templates
    public String hello() {
        return "<html>" +
                    "<body>" +
                        "<form action='hello' method='post'>" +
                            "<input type='text' name='name'>" +
                            "<select name='langSelect'>Choose a language:" +
                            "    <option value='english'>English</option>\n" +
                            "    <option value='french'>French</option>\n" +
                            "    <option value='spanish'>Spanish</option>\n" +
                            "    <option value='swedish'>Swedish</option>\n" +
                            "    <option value='southern'>Southern</option></select>" +
                        "<input type='submit' value='Greet Me!'>" +
                         "</form>" +
                    "</body>" +
                "</html>";
    }

    @RequestMapping(method = {RequestMethod.POST}, value = "hello")
    @ResponseBody
    public String createMessage(@RequestParam String langSelect, @RequestParam String name ) {
        String greeting = "";
        if (name == null) {
            name = "World";
        }
        System.out.println("in create message");

        if (langSelect.equals("english")) {
            greeting = "Hello, ";
        }
        else if (langSelect.equals("spanish")) {
            greeting = "Hola, ";
        }
        else if (langSelect.equals("french")) {
            greeting = "Bonjour, ";
        }
        else if (langSelect.equals("swedish")) {
            greeting = "Hallo, ";
        }
        else if (langSelect.equals("southern")) {
            greeting = "Howdy, ";
        }
        return greeting + name;
    }
}
