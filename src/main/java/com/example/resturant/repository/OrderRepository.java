package com.example.resturant.repository;

import com.example.resturant.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

//    @Query("SELECT o.oId FROM Order o WHERE o.tblorder.tblId = :tblId")
//    Integer findOIdByTblId(@Param("tblId") Integer tblId);

    @Query("SELECT o.oId FROM Order o WHERE o.tblorder.tId = :tblId")
    Integer findOrderIdByTableId(@Param("tblId") Integer tblId);
}
