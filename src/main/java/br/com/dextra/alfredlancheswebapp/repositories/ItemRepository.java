package br.com.dextra.alfredlancheswebapp.repositories;

import br.com.dextra.alfredlancheswebapp.models.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> {
}
