package com.billing.system.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.system.model.CustomerDetails;
import com.billing.system.model.ItemQuotation;
import com.billing.system.repository.ItemQuotationRepository;
import com.billing.system.services.ItemQuotationService;

@Service
public class ItemQuotationServiceImpl implements ItemQuotationService {

	private final ItemQuotationRepository itemQuotationRepository;

	public ItemQuotationServiceImpl(ItemQuotationRepository itemQuotationRepository) {
		this.itemQuotationRepository = itemQuotationRepository;
	}

	@Override
	public boolean createItemQuotation(List<ItemQuotation> itemQuotationList, CustomerDetails customer) {
		for (ItemQuotation itemQuotation : itemQuotationList) {
			itemQuotation.setCustomerDetails(customer);
			itemQuotationRepository.save(itemQuotation);
		}
		return false;
	}

}
