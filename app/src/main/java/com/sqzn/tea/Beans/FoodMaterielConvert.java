package com.sqzn.tea.Beans;

import com.alibaba.fastjson.JSON;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.List;

public class FoodMaterielConvert  implements PropertyConverter<List<FoodMateriel>,String> {

    @Override
    public List<FoodMateriel> convertToEntityProperty(String databaseValue) {
        return JSON.parseArray(databaseValue, FoodMateriel.class);
    }

    @Override
    public String convertToDatabaseValue(List<FoodMateriel> entityProperty) {
        return JSON.toJSONString(entityProperty);
    }
}
