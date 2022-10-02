package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {


    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "hello2")
    public String hello2(@RequestParam String name, Model model) {
        String greeting = "Hello there, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello2";
    }



    @GetMapping("hello2/{name}")
    public String helloPath(@PathVariable String name, Model model) {
        String greeting = "hello to you, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello2";
    }

    @GetMapping("form") //static
    public String form () {
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("valerie");
        names.add("jaxen");
        names.add("molly");
        model.addAttribute("names", names);
        return "hello-list";
    }
}
