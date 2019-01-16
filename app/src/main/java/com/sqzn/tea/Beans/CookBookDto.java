package com.sqzn.tea.Beans;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

import java.util.List;

@Entity
public class CookBookDto {
    private String id;
    private String pictureImgUrl;
    private String name;
    private String author;
    private String introduction;

    @Convert(converter = FoodMaterielConvert.class, columnType = String.class)
    private List<FoodMateriel> foodMaterielList;
    @Convert(converter = StepConvert.class, columnType = String.class)
    private List<Step> steps;



    @Generated(hash = 142886395)
    public CookBookDto(String id, String pictureImgUrl, String name, String author,
            String introduction, List<FoodMateriel> foodMaterielList,
            List<Step> steps) {
        this.id = id;
        this.pictureImgUrl = pictureImgUrl;
        this.name = name;
        this.author = author;
        this.introduction = introduction;
        this.foodMaterielList = foodMaterielList;
        this.steps = steps;
    }

    @Generated(hash = 976864834)
    public CookBookDto() {
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

    public List<Step> getSteps() {
        return this.steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
