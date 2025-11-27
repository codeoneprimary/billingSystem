package com.billing.system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billing.system.dto.ApiResponseDto;
import com.billing.system.dto.PurchaseOrderBillDto;
import com.billing.system.model.CustomerDetails;
import com.billing.system.model.PurchaseOrder;
import com.billing.system.model.User;
import com.billing.system.services.CustomerDetailsService;
import com.billing.system.services.PurchaseOrderService;

@RestController
@RequestMapping("/api/purchaseorders")
public class PurchaseOrderController {

	private final PurchaseOrderService purchaseOrderService;
	private final CustomerDetailsService customerDetailsService;

	public PurchaseOrderController(PurchaseOrderService purchaseOrderService,
			CustomerDetailsService customerDetailsService) {
		this.purchaseOrderService = purchaseOrderService;
		this.customerDetailsService = customerDetailsService;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponseDto<PurchaseOrder>> savePurchaseOrder(
			@RequestBody PurchaseOrderBillDto purchaseOrderBillDto) {

		User loginUser = new User();
		loginUser.setRegUserId((long) 1);

		CustomerDetails customerDetails = customerDetailsService.saveCustomerDetails(purchaseOrderBillDto, loginUser);

		PurchaseOrder purchaseOrder = purchaseOrderService.savePurchaseOrder(purchaseOrderBillDto, customerDetails,
				loginUser);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ApiResponseDto.success("Purchase Order Saved", purchaseOrder));
	}
}
