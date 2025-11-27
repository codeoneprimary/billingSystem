package com.billing.system.services;

import java.util.List;

import com.billing.system.model.Item;

public interface ItemService {

	List<Item> allItemList();

	boolean updateItemStock(Item item);

	Item getItemDetailsByItemId(Long itemId);
}
