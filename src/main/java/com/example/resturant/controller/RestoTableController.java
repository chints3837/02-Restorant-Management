package com.example.resturant.controller;

import com.example.resturant.entity.RestoTable;
import com.example.resturant.serviceImpl.RestoTableServiceImpl;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestoTableController {

    @Autowired
    private RestoTableServiceImpl restoTableService;


    @PostMapping("/addTable")
    public RestoTable addTable(@RequestBody RestoTable restoTable){

        RestoTable restoTableResult =restoTableService.addTable(restoTable);
        return restoTableResult;
    }

    @GetMapping("/getTableById")
    public RestoTable getTableById(@RequestParam("tId") Integer tId){
        RestoTable restoTableResult=restoTableService.getTableById(tId);
        return restoTableResult;
    }
}
