package com.billing.system.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.system.model.GSTCategory;
import com.billing.system.repository.GSTCategoryRepository;
import com.billing.system.services.GSTCategoryService;

@Service
public class GSTCategoryServiceImpl implements GSTCategoryService {

	private final GSTCategoryRepository gstCategoryRepository;

	public GSTCategoryServiceImpl(GSTCategoryRepository gstCategoryRepository) {
		this.gstCategoryRepository = gstCategoryRepository;

	}

	@Override
	public List<GSTCategory> allGSTCategoryList() {
		return gstCategoryRepository.findAll();
	}

}
