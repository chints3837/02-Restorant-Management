package com.example.resturant.service;

import com.example.resturant.entity.RestoTable;

public interface RestoTableService {

    RestoTable addTable(RestoTable restoTable);

    RestoTable getTableById(Integer id);
}
