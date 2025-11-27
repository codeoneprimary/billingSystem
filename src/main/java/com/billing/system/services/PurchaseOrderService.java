package com.billing.system.services;

import com.billing.system.dto.PurchaseOrderBillDto;
import com.billing.system.model.CustomerDetails;
import com.billing.system.model.PurchaseOrder;
import com.billing.system.model.User;

public interface PurchaseOrderService {

	PurchaseOrder savePurchaseOrder(PurchaseOrderBillDto purchaseOrderBillDto, CustomerDetails customerDetails,
			User loginUser);

}
