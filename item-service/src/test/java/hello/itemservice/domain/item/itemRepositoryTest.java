package hello.itemservice.domain.item;


import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class itemRepositoryTest {

  ItemRepository itemRepository = new ItemRepository();

  @AfterEach
  void afterEach() {
    itemRepository.clearStore();
  }

  @Test
  void save() throws Exception {
    Item item = new Item("itemA", 10000, 10);
    Item savedItem = itemRepository.save(item);
    itemRepository.findById(item.getId());
    assertThat(item).isEqualTo(savedItem);
  }

  @Test
  void findAll() throws Exception {
    Item item1 = new Item("item1", 10000, 10);
    Item item2 = new Item("item2", 20000, 20);
    itemRepository.save(item1);
    itemRepository.save(item2);

    List<Item> result = itemRepository.findAll();
    assertThat(result.size()).isEqualTo(2);
    assertThat(result).contains(item1, item2);
  }

  @Test
  void updateItem() throws Exception {
    Item item = new Item("item1", 10000, 10);

    Item save = itemRepository.save(item);
    Long itemId = save.getId();

    Item updateParam = new Item("item2", 20000, 30);
    itemRepository.update(itemId,updateParam);

    Item findItem = itemRepository.findById(itemId);

    assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
  }
}
