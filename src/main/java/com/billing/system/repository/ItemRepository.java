package com.billing.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billing.system.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	Item findAllByItemId(Long itemId);

}
