package com.VintageStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VintageStore.entity.MyClotheList;

@Repository
public interface MyClotheRepository extends JpaRepository<MyClotheList,Integer>{

}
