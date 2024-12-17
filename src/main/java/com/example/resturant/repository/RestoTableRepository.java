package com.example.resturant.repository;

import com.example.resturant.entity.RestoTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestoTableRepository extends JpaRepository<RestoTable,Integer> {
}
