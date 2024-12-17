package com.example.resturant.serviceImpl;

import com.example.resturant.entity.RestoTable;
import com.example.resturant.repository.RestoTableRepository;
import com.example.resturant.service.RestoTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestoTableServiceImpl implements RestoTableService {


    @Autowired
    private RestoTableRepository restoTableRepository;

    @Override
    public RestoTable addTable(RestoTable restoTable) {
        RestoTable restoTableResult= restoTableRepository.save(restoTable);
        return restoTableResult;
    }

    @Override
    public RestoTable getTableById(Integer id) {
        Optional<RestoTable> restoTableResult = restoTableRepository.findById(id);
        return restoTableResult.get();
    }


}
