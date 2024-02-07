package com.VintageStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.VintageStore.entity.Clothe;
import com.VintageStore.entity.MyClotheList;
import com.VintageStore.service.ClotheService;
import com.VintageStore.service.MyClotheListService;

import java.util.*;

@Controller
public class ClotheController {
	
	@Autowired
	private ClotheService service;
	
	@Autowired
	private MyClotheListService myBookService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/add_clothe")
	public String addClothe() {
		return "addclothe";
	}
	
	@GetMapping("/available_clothes")
	public ModelAndView getAllClothes() {
		List<Clothe>list=service.getAllClothes();
	ModelAndView m=new ModelAndView();
		m.setViewName("clotheList");
	m.addObject("clothe",list);
		return new ModelAndView("ClotheList","Clothe",list);
	}
	
	@PostMapping("/save")
	public String addClothe(@ModelAttribute Clothe c) {
		service.save(c);
		return "redirect:/available_clothe";
	}
	@GetMapping("/my_clothes")
	public String getMyClothes(Model model)
	{
		List<Clothe> list=ClotheService.getAllClothes();
		model.addAttribute("clothe",list);
		return "myClothe";
	}
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Clothe b=service.getClotheById(id);
		MyClotheList mc=new MyClotheList(b.getId(),b.getName(),b.getBrand(),b.getPrice());
		myBookService.saveMyClothes(mc);
		return "redirect:/my_clothes";
	}
	
	@RequestMapping("/editClothe/{id}")
	public String editClothe(@PathVariable("id") int id,Model model) {
		Clothe c=service.getClotheById(id);
		model.addAttribute("clothe",c);
		return "clotheEdit";
	}
	@RequestMapping("/deleteClothe/{id}")
	public String deleteClothe(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/available_clothes";
	}
	
}
