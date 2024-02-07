package com.VintageStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VintageStore.entity.Clothe;
import com.VintageStore.repository.ClotheRepository;

@Service
public class ClotheService {
	
	@Autowired
	private static ClotheRepository cRepo;
	
	public void save(Clothe c) {
		cRepo.save(c);
	}
	
	public static List<Clothe> getAllClothes(){
		return cRepo.findAll();
	}
	
	public Clothe getClotheById(int id) {
		return cRepo.findById(id).get();
	}
	public void deleteById(int id) {
		cRepo.deleteById(id);
	}
}
