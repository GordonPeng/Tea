package com.sqzn.tea.Beans;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

import java.util.List;

@Entity
public class TeaDto {
    private String pictureImgUrl;
    private String name;
    private String introduction;

    @Convert(converter = FoodMaterielConvert.class, columnType = String.class)
    private List<FoodMateriel> foodMaterielList;

    @Generated(hash = 62748101)
    public TeaDto(String pictureImgUrl, String name, String introduction,
            List<FoodMateriel> foodMaterielList) {
        this.pictureImgUrl = pictureImgUrl;
        this.name = name;
        this.introduction = introduction;
        this.foodMaterielList = foodMaterielList;
    }

    @Generated(hash = 276906914)
    public TeaDto() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureImgUrl() {
        return this.pictureImgUrl;
    }

    public void setPictureImgUrl(String pictureImgUrl) {
        this.pictureImgUrl = pictureImgUrl;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public List<FoodMateriel> getFoodMaterielList() {
        return this.foodMaterielList;
    }

    public void setFoodMaterielList(List<FoodMateriel> foodMaterielList) {
        this.foodMaterielList = foodMaterielList;
    }

}
