package com.catsapi.controllers;

import com.catsapi.exceptions.CatAlreadyExistException;
import com.catsapi.models.CatModel;
import com.catsapi.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cats")
@RequiredArgsConstructor
public class CatController {

    private final CatService catService;

    @PostMapping
    public ResponseEntity save(@RequestBody CatModel catModel){
        try {
            catService.save(catModel);
            return ResponseEntity.ok("Котик создан!");
        }catch (CatAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable int id){
        try {

            return ResponseEntity.ok(catService.getOneCatById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Не получилось найти котика!");
        }
    }
    @GetMapping("//{name}")
    public ResponseEntity getByName(@PathVariable String name){
        try {
            return ResponseEntity.ok(catService.getOneCatByName(name));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Не получилось найти котика!");
        }
    }

    @GetMapping
    public List<CatModel> getAll(){
        return catService.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable int id){
        try {
            catService.deleteById(id);
            return ResponseEntity.ok("Котик удален!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Не получилось удалить котика!");
        }
    }
    @DeleteMapping("//{name}")
    public ResponseEntity deleteByName(@PathVariable String name){
        try {
            catService.deleteByName(name);
            return ResponseEntity.ok("Котик удален!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Не получилось удалить котика!");
        }
    }

}
