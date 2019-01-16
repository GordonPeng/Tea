package com.sqzn.tea.Beans;

import com.alibaba.fastjson.JSON;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.List;

public class StepConvert implements PropertyConverter<List<Step>,String> {

    @Override
    public List<Step> convertToEntityProperty(String databaseValue) {
        return JSON.parseArray(databaseValue, Step.class);
    }

    @Override
    public String convertToDatabaseValue(List<Step> entityProperty) {
        return JSON.toJSONString(entityProperty);
    }
}
