package com.VintageStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VintageStore.entity.MyClotheList;
import com.VintageStore.repository.MyClotheRepository;

@Service
public class MyClotheListService {
	
	@Autowired
	private MyClotheRepository myclothe;
	
	public void saveMyClothes(MyClotheList book) {
		myclothe.save(book);
	}
	
	public List<MyClotheList> getAllClothes(){
		return myclothe.findAll();
	}
	
	public void deleteById(int id) {
		myclothe.deleteById(id);
	}
}
