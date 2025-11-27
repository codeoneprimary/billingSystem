package com.billing.system.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.billing.system.model.Item;
import com.billing.system.services.CustomerDetailsService;
import com.billing.system.services.GSTCategoryService;
import com.billing.system.services.ItemCategoryService;
import com.billing.system.services.ItemService;
import com.billing.system.services.ItemUnitService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class LoginController {

	private final ItemCategoryService itemCategoryService;
	private final CustomerDetailsService customerDetailsService;
	private final ItemService itemService;
	private final ItemUnitService itemUnitService;
	private final GSTCategoryService gstCategoryService;

	public LoginController(ItemCategoryService itemCategoryService, CustomerDetailsService customerDetailsService,
			ItemService itemService, ItemUnitService itemUnitService, GSTCategoryService gstCategoryService) {
		this.itemCategoryService = itemCategoryService;
		this.customerDetailsService = customerDetailsService;
		this.itemService = itemService;
		this.itemUnitService = itemUnitService;
		this.gstCategoryService = gstCategoryService;
	}

	@GetMapping("/itemCategory")
	public String itemCategory(Model model) {

		model.addAttribute("itemCategoryList", itemCategoryService.allItemCategoryList());
		return "itemCategory";
	}

	@GetMapping("/itemMaster")
	public String itemMaster(Model model) {

		model.addAttribute("gstCategoryList", gstCategoryService.allGSTCategoryList());
		model.addAttribute("itemUnitList", itemUnitService.allItemUnitList());
		model.addAttribute("itemCategoryList", itemCategoryService.allItemCategoryList());
		model.addAttribute("itemList", itemService.allItemList());
		return "itemMaster";
	}

	@GetMapping("/itemQuotation")
	public String itemQuotation(Model model) {

		model.addAttribute("itemList", itemService.allItemList());
		model.addAttribute("customerList", customerDetailsService.allCustomerList());
		model.addAttribute("itemCategoryList", itemCategoryService.allItemCategoryList());
		return "itemQuotation";
	}

	@GetMapping("/purchaseOrder")
	public String purchaseOrder(Model model) {
		try {
			List<Item> itemList = itemService.allItemList();
			model.addAttribute("itemList", itemList);
			model.addAttribute("customerList", customerDetailsService.allCustomerList());
			model.addAttribute("itemCategoryList", itemCategoryService.allItemCategoryList());

			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(itemList);
			model.addAttribute("itemListJson", json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "purchaseOrder";
	}

	@GetMapping("/userLogin")
	public String userLogin() {
		return "userLogin";
	}

	@GetMapping("/userRegistration")
	public String userRegistration() {
		return "userRegistration";
	}

	@GetMapping("/userRegistrationOtp")
	public String userRegistrationOtp() {
		return "userRegistrationOtp";
	}

}
