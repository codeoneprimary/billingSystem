package com.billing.system.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.system.model.Item;
import com.billing.system.services.ItemService;
import com.billing.system.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	private final ItemRepository itemRepository;

	public ItemServiceImpl(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;

	}

	@Override
	public List<Item> allItemList() {
		return itemRepository.findAll();
	}

	@Override
	public boolean updateItemStock(Item item) {
		itemRepository.save(item);
		return false;
	}

	@Override
	public Item getItemDetailsByItemId(Long itemId) {
		return itemRepository.findAllByItemId(itemId);
	}

}
