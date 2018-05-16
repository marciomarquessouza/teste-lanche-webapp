package br.com.dextra.alfredlancheswebapp.bootstrap;

import br.com.dextra.alfredlancheswebapp.models.Item;
import br.com.dextra.alfredlancheswebapp.models.ItemRecipe;
import br.com.dextra.alfredlancheswebapp.models.Recipe;
import br.com.dextra.alfredlancheswebapp.repositories.ItemRepository;
import br.com.dextra.alfredlancheswebapp.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Cria os dados de Itens (Ingredientes), Receitas (Lanches), Pedidos e Promoções
 *
 */

@Component
public class ItemLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ItemRepository itemRepository;
    private RecipeRepository recipeRepository;

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Autowired
    public void setRecipeRepository(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    /**
     * Envocado no início do sistema
     * @param event
     */

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        /**
         * Criação dos dados de Itens
         */

        Item alface = new Item();
        alface.setCode("ing-001");
        alface.setDescription("Alface");
        alface.setPrice(0.40);
        alface.setImageUrl("https://drive.google.com/file/d/1c3MdSgmIcDPhn_dSrKKHK5opG8wZ0Ihc");
        itemRepository.save(alface);

        Item bacon = new Item();
        bacon.setCode("ing-002");
        bacon.setDescription("Bacon");
        bacon.setPrice(2.00);
        bacon.setImageUrl("https://drive.google.com/file/d/18BtTweANOA88oaNDVuLLzsTdf3HNNjqL");
        itemRepository.save(bacon);

        Item hamburguerCarne = new Item();
        hamburguerCarne.setCode("ing-003");
        hamburguerCarne.setDescription("Hambúrguer de Carne");
        hamburguerCarne.setPrice(3.00);
        hamburguerCarne.setImageUrl("https://drive.google.com/file/d/1AamN4SQquyewzXq7o_Tb8Anb_N7bhiyy");
        itemRepository.save(hamburguerCarne);

        Item ovo = new Item();
        ovo.setCode("ing-004");
        ovo.setDescription("Ovo");
        ovo.setPrice(0.8);
        ovo.setImageUrl("https://drive.google.com/file/d/1w1lSVN8883419Is9jmo2TXYw8eFK2K8Y");
        itemRepository.save(ovo);

        Item queijo = new Item();
        queijo.setCode("ing-005");
        queijo.setDescription("Queijo");
        queijo.setPrice(1.50);
        queijo.setImageUrl("https://drive.google.com/file/d/1ZcnhYpcRO-JAQCHxnqzsVYw8tA1g98Ch");
        itemRepository.save(queijo);

        /**
         * Criação das Receitas
         */

        //*** X-Bacon ****
        Recipe xbacon = new Recipe("X-Bacon");
        Set itemXBacon = new HashSet<ItemRecipe>(){
            {
                add(new ItemRecipe("bacon", xbacon));
                add(new ItemRecipe("hambúrguer de carne", xbacon));
                add(new ItemRecipe("queijo", xbacon));
            }
        };

        xbacon.setItemRecipes(itemXBacon);
        recipeRepository.save(xbacon);


        //*** X-Burger ****
        Recipe xburger = new Recipe("X-Burger");
        Set itemXBurger = new HashSet<ItemRecipe>(){
            {
                add(new ItemRecipe("hambúrguer de carne", xburger));
                add(new ItemRecipe("queijo", xburger));
            }
        };

        xburger.setItemRecipes(itemXBurger);
        recipeRepository.save(xburger);

    }
}
