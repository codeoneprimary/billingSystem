package com.billing.system.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.system.model.ItemUnit;
import com.billing.system.repository.ItemUnitRepository;
import com.billing.system.services.ItemUnitService;

@Service
public class ItemUnitServiceImpl implements ItemUnitService {

	private final ItemUnitRepository itemUnitRepository;

	public ItemUnitServiceImpl(ItemUnitRepository itemUnitRepository) {
		this.itemUnitRepository = itemUnitRepository;
	}

	@Override
	public List<ItemUnit> allItemUnitList() {
		return itemUnitRepository.findAll();
	}
}
