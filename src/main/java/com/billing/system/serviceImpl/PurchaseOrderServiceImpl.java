package com.billing.system.serviceImpl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.billing.system.commons.BillingConstant;
import com.billing.system.dto.ItemDto;
import com.billing.system.dto.PurchaseOrderBillDto;
import com.billing.system.model.CustomerDetails;
import com.billing.system.model.Item;
import com.billing.system.model.ItemStockHistory;
import com.billing.system.model.PurchaseOrder;
import com.billing.system.model.PurchaseOrderItem;
import com.billing.system.model.User;
import com.billing.system.repository.PurchaseOrderRepository;
import com.billing.system.repository.ItemStockHistoryRepository;
import com.billing.system.repository.PurchaseOrderItemRepository;
import com.billing.system.services.ItemService;
import com.billing.system.services.PurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	private final PurchaseOrderRepository purchaseOrderRepository;

	private final PurchaseOrderItemRepository purchaseOrderItemRepository;

	private final ItemStockHistoryRepository itemStockHistoryRepository;

	private final ItemService itemService;

	public PurchaseOrderServiceImpl(PurchaseOrderRepository purchaseOrderRepository,
			PurchaseOrderItemRepository purchaseOrderItemRepository,
			ItemStockHistoryRepository itemStockHistoryRepository, ItemService itemService) {
		this.purchaseOrderRepository = purchaseOrderRepository;
		this.purchaseOrderItemRepository = purchaseOrderItemRepository;
		this.itemStockHistoryRepository = itemStockHistoryRepository;
		this.itemService = itemService;
	}

	@Override
	public PurchaseOrder savePurchaseOrder(PurchaseOrderBillDto purchaseOrderBillDto, CustomerDetails customerDetails,
			User loginUser) {

		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder.setCustomerDetails(customerDetails);
		purchaseOrder.setTotalBillAmount(purchaseOrderBillDto.getTotalBillAmount());
		purchaseOrder.setDiscount(purchaseOrderBillDto.getDiscount());
		purchaseOrder.setUser(loginUser);
		purchaseOrder.setCreatedDate(new Date());
		purchaseOrderRepository.save(purchaseOrder);

		PurchaseOrderItem purchaseOrderItem = new PurchaseOrderItem();
		ItemStockHistory itemStockHistory = new ItemStockHistory();
		Item item = new Item();
		try {
			for (ItemDto itemDto : purchaseOrderBillDto.getItemDto()) {
				purchaseOrderItem = new PurchaseOrderItem();
				itemStockHistory = new ItemStockHistory();
				item = itemService.getItemDetailsByItemId(itemDto.getItemId());
				item.setItemStock(item.getItemStock() - itemDto.getItemQuantity());
				purchaseOrderItem.setItem(item);
				purchaseOrderItem.setItemCode(itemDto.getItemCode());
				purchaseOrderItem.setItemRate(itemDto.getItemRate());
				purchaseOrderItem.setItemQuantity(itemDto.getItemQuantity());
				purchaseOrderItem.setUnit(itemDto.getUnit());
				purchaseOrderItem.setGst(itemDto.getGst());
				purchaseOrderItem.setDiscount(itemDto.getDiscount());
				purchaseOrderItem.setTotalPrice(itemDto.getTotalPrice());
				purchaseOrderItem.setPurchaseOrder(purchaseOrder);
				purchaseOrderItemRepository.save(purchaseOrderItem);

				itemStockHistory.setItem(item);
				itemStockHistory.setStock(itemDto.getItemQuantity());
				itemStockHistory.setTransactionType(BillingConstant.DEBITED);
				itemStockHistory.setUser(loginUser);
				itemStockHistory.setCreatedDate(new Date());
				itemStockHistoryRepository.save(itemStockHistory);

			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return purchaseOrder;
	}

}
