package com.billing.system.services;

import java.util.List;

import com.billing.system.dto.PurchaseOrderBillDto;
import com.billing.system.model.CustomerDetails;
import com.billing.system.model.User;

public interface CustomerDetailsService {

	List<CustomerDetails> allCustomerList();

	CustomerDetails saveCustomerDetails(PurchaseOrderBillDto purchaseOrderBillDto, User loginUser);

}
