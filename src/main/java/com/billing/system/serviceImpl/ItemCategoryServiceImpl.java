package com.billing.system.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.system.model.ItemCategory;
import com.billing.system.repository.ItemCategoryRepository;
import com.billing.system.services.ItemCategoryService;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {

	private final ItemCategoryRepository itemCategoryRepository;

	public ItemCategoryServiceImpl(ItemCategoryRepository itemCategoryRepository) {
		this.itemCategoryRepository = itemCategoryRepository;
	}

	@Override
	public List<ItemCategory> allItemCategoryList() {
		return itemCategoryRepository.findAll();
	}

}
