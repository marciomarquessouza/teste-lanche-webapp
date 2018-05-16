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
public class ItemController {

    private ItemService itemService;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value = "item/new", method = RequestMethod.POST)
    public String newItem(Model model) {
        model.addAttribute("item", new Item());
        return "admintemplate/pages/itemform";
    }

    @RequestMapping(value = "item", method = RequestMethod.POST)
    public String saveItem(Item item) {
        itemService.saveItem(item);
        return "redirect:/items";
    }

    @RequestMapping(value="item/{id}", method = RequestMethod.GET)
    public String showItem(@PathVariable Integer id, Model model) {
        model.addAttribute("item", itemService.getItemById(id));
        return "itemshow";
    }

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("items", itemService.listAllItems());
        return  "admintemplate/pages/items";
    }

    @RequestMapping("item/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("item", itemService.getItemById(id));
        return "admintemplate/pages/itemshow";
    }

    @RequestMapping(value = "item/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        itemService.deleteItem(itemService.getItemById(id));
        return "redirect:/items";
    }

}
