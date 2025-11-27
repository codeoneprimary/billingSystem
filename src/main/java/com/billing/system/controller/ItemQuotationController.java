package com.billing.system.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billing.system.dto.ApiResponseDto;
import com.billing.system.dto.PurchaseOrderBillDto;
import com.billing.system.model.CustomerDetails;
import com.billing.system.model.ItemQuotation;
import com.billing.system.model.User;
import com.billing.system.services.CustomerDetailsService;
import com.billing.system.services.ItemQuotationService;

@RestController
@RequestMapping("/api/quotation")
public class ItemQuotationController {


	@PostMapping
	public ResponseEntity<ApiResponseDto<Boolean>> createQuotation(
			@RequestBody PurchaseOrderBillDto purchaseOrderBillDto) {
		User loginUser = new User();
		loginUser.setRegUserId((long) 1);

		//CustomerDetails customerDetails = customerDetailsService.saveCustomerDetails(purchaseOrderBillDto, loginUser);

		boolean status = false;// = itemQuotationService.createItemQuotation(ItemQuotation, customer);

		return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseDto.success("User otp verified", status));
	}
}
