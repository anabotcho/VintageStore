package com.VintageStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VintageStore.entity.Clothe;

@Repository
public interface ClotheRepository extends JpaRepository<Clothe,Integer>  {

}
