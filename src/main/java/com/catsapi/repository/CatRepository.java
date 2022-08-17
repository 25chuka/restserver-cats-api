package com.catsapi.repository;

import com.catsapi.entity.CatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<CatEntity, Integer> {
    CatEntity findByName(String name);

}
