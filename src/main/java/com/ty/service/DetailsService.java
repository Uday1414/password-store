package com.ty.service;

import java.util.List;

import com.ty.dao.DetailsDao;
import com.ty.dto.DetailsDto;

public class DetailsService {
	DetailsDao detailsDao = new DetailsDao();
	
	public DetailsDto saveDetails(DetailsDto detailsDto , int id) {
		return detailsDao.saveDetails(detailsDto , id);
	}
	
	public List<DetailsDto> getByUserId(int id){
		return detailsDao.getByUserId(id);
	}
}
