package com.catsapi.service;

import com.catsapi.entity.CatEntity;
import com.catsapi.exceptions.CatAlreadyExistException;
import com.catsapi.models.CatModel;
import com.catsapi.repository.CatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CatService {

    private final CatRepository catRepository;


    public CatEntity save(CatModel catModel) throws CatAlreadyExistException {
        CatEntity cat = new CatEntity()
                .setName(catModel.getName())
                .setBirthDay(catModel.getBirthDay())
                .setCreatedAt(LocalDateTime.now());
        if (catRepository.findByName(cat.getName()) == null)
            return catRepository.save(cat);
        else
            throw new CatAlreadyExistException("Такой котик уже есть!");
    }

    public void deleteById(int id){
        catRepository.deleteById(id);
    }
    public void deleteByName(String name){
        CatEntity cat = catRepository.findByName(name);
        catRepository.deleteById(cat.getId());
    }

    public CatModel getOneCatById(int id){
       CatEntity cat = catRepository.findById(id).get();
       return CatModel.toModel(cat);
    }
    public CatModel getOneCatByName(String name){
        CatEntity cat = catRepository.findByName(name);
        return CatModel.toModel(cat);
    }
    public List<CatModel> getAll(){
        List<CatModel> catModels = new ArrayList<>();
        List<CatEntity> catEntities =  catRepository.findAll();

        for (CatEntity cat: catEntities) {
            catModels.add(CatModel.toModel(cat));
        }
        return catModels;
    }

}
