package br.com.dextra.alfredlancheswebapp.controllers;


import br.com.dextra.alfredlancheswebapp.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import br.com.dextra.alfredlancheswebapp.models.Item;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class itemController {

    private ItemService itemService;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping("item/new")
    public String newItem(Model model) {
        model.addAttribute("item", new Item());
        return "itemformrest";
    }

    @RequestMapping(value = "item", method = RequestMethod.POST)
    public String saveItem(Item item) {
        itemService.saveItem(item);
        return "redirect:/item/" + item.getId();
    }

    @RequestMapping("item/{id}")
    public String showItem(@PathVariable Integer id, Model model) {
        model.addAttribute("item", itemService.getItemById(id));
        return "itemshow";
    }

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("items", itemService.listAllItems());
        return  "items";
    }

    @RequestMapping("item/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("item", itemService.getItemById(id));
        return "itemform";
    }

    @RequestMapping("item/delete/{id}")
    public String delete(@PathVariable Integer id) {
        itemService.deleteItem(itemService.getItemById(id));
        return "redirect:/items";
    }

}
