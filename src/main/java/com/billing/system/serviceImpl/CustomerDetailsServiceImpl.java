package com.billing.system.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.billing.system.dto.PurchaseOrderBillDto;
import com.billing.system.model.CustomerDetails;
import com.billing.system.model.User;
import com.billing.system.repository.CustomerDetailsRepository;
import com.billing.system.services.CustomerDetailsService;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

	private final CustomerDetailsRepository customerDetailsRepository;

	public CustomerDetailsServiceImpl(CustomerDetailsRepository customerDetailsRepository) {
		this.customerDetailsRepository = customerDetailsRepository;
	}

	@Override
	public List<CustomerDetails> allCustomerList() {
		return customerDetailsRepository.findAll();
	}

	@Override
	public CustomerDetails saveCustomerDetails(PurchaseOrderBillDto purchaseOrderBillDto, User loginUser) {
		Optional<CustomerDetails> customerExisting = customerDetailsRepository
				.findByMobileNo(purchaseOrderBillDto.getMobileNo());

		if (customerExisting.isPresent()) {
			// Return existing customer
			return customerExisting.get();
		}
		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setCustomerName(purchaseOrderBillDto.getCustomerName());
		customerDetails.setMobileNo(purchaseOrderBillDto.getMobileNo());
		customerDetails.setEmailId(purchaseOrderBillDto.getEmailId());
		customerDetails.setAddress(purchaseOrderBillDto.getAddress());
		customerDetails.setUser(loginUser);
		customerDetails.setCreatedDate(new Date());
		return customerDetailsRepository.save(customerDetails);
	}

}
