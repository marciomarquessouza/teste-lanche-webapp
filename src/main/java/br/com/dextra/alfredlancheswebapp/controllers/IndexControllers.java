package br.com.dextra.alfredlancheswebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexControllers {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
