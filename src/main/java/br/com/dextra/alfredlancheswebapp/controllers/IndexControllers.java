package br.com.dextra.alfredlancheswebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexControllers {

    //Página principal do App
    @RequestMapping("/")
    public String index() {
        return "frontend/index";
    }

    /*
    * Para facilitar o cadastro e gestão dos registros, foram criadas as
    * aplicações de administração do sistema
     */
    @RequestMapping("/admin")
    public String indexAdmin() {
        return "admintemplate/pages/home";
    }

    @RequestMapping("admin/itens")
    public String adminItens() {
        return "redirect:/items";
    }

    @RequestMapping("admin/recipes")
    public String adminRecipes() {
        return "redirect:/recipes";
    }

}
