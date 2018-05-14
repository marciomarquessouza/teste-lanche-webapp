package br.com.dextra.alfredlancheswebapp.controllers;

import java.util.ArrayList;
import java.util.List;

import br.com.dextra.alfredlancheswebapp.message.Response;
import br.com.dextra.alfredlancheswebapp.models.Item;
import br.com.dextra.alfredlancheswebapp.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item/new/api")
public class itemRestWebController {

    private ItemService itemService;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(value = "/save")
    public Response postItem(@RequestBody Item item) {

        itemService.saveItem(item);
        Response response = new Response("Done", item);
        return response;
    }

    @GetMapping(value = "/all")
    public Response getAllItem() {
        Response response = new Response("Done", itemService.listAllItems());
        return response;
    }

    @GetMapping(value = "/view")
    public Response getItem(@RequestBody Integer id) {

        Response response = new Response("Done", itemService.getItemById(id));
        return response;
    }

    @DeleteMapping(value = "/remove")
    public Response deleteItem(@RequestBody Item item) {

        itemService.deleteItem(item);
        Response response = new Response("Done", itemService.listAllItems());
        return response;

    }

}
