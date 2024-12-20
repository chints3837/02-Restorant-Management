package com.example.resturant.serviceImpl;

import com.example.resturant.entity.RestoTable;
import com.example.resturant.exception.UserException;
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
        String ex;

        try{
            if(restoTable.gettName()==null){
                ex="Please Enter table name";
                throw new Exception(ex);
            }
        }catch (Exception e){
            System.out.println("Exception Occured");
        }
        RestoTable restoTableResult= restoTableRepository.save(restoTable);
        return restoTableResult;
    }

    @Override
    public RestoTable getTableById(Integer id) {
        try{
            if(id==null){
                throw new UserException("please enter table id");
            }
        }catch (Exception e){
            System.out.println("Exception occured :"+e.toString());
        }

        Optional<RestoTable> restoTableResult = restoTableRepository.findById(id);
        try{
            if(restoTableResult.get()==null){
                throw new Exception("Restorant Table not Found !");
            }
        }catch (Exception e){
            System.out.println("Exception Occured :"+e.toString());
        }

        return restoTableResult.get();
    }


}
