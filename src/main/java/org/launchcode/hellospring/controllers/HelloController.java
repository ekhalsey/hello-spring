package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
public class HelloController {

    //Handles requests at /hello
    @GetMapping("hello") //should handle Get requests only
    @ResponseBody //returns plain text response, wont use once there are templates
    public String hello() {
        return "Hello, Spring!";
    }

    //handles requests at /goodbye
    @GetMapping("goodbye") //should handle Get requests only
    @ResponseBody //returns plain text response, wont use once there are templates
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "demonName")
    @ResponseBody
    public String banishParam(@RequestParam String demonName) {
        return "get thee hence, " + demonName + "!";

    }

    @GetMapping("hello/{flowers}")
    @ResponseBody
    public String helloPath(@PathVariable String flowers) {
        return "i like " + flowers + "!";
    }

    @GetMapping("form")
    @ResponseBody
    public String banishForm () {
        return "<html>" +
                "<body>" +
                "<form action='demonName' method='post'>" +
                "<input type='text' name='demonName'>" +
                "<input type='submit' value='Banish Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
