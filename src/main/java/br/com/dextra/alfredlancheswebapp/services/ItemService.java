package br.com.dextra.alfredlancheswebapp.services;

import br.com.dextra.alfredlancheswebapp.models.Item;

public interface ItemService {

    Iterable<Item> listAllItems();

    Item getItemById(Integer id);

    Item saveItem(Item item);

    void deleteItem(Item item);
}
