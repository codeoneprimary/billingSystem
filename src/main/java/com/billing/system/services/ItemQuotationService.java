package com.billing.system.services;

import java.util.List;

import com.billing.system.model.CustomerDetails;
import com.billing.system.model.ItemQuotation;

public interface ItemQuotationService {

	boolean createItemQuotation(List<ItemQuotation> itemQuotation, CustomerDetails customer);

}
