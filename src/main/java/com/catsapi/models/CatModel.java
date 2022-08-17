package com.catsapi.models;

import com.catsapi.entity.CatEntity;
import lombok.Data;
import lombok.experimental.Accessors;
import java.time.LocalDate;
@Data
@Accessors(chain = true)
public class CatModel {
    private String name;
    private LocalDate birthDay;

    public static CatModel toModel(CatEntity cat){
        CatModel catModel = new CatModel()
                .setName(cat.getName())
                .setBirthDay(cat.getBirthDay());
        return catModel;
    }

}
