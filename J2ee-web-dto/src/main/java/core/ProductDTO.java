package core;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class ProductDTO implements Serializable {

    String id;
    String name;
    String description;
    int quantity;
    double selPrice;
    double costPrice;
    String imageUrl;
    String[] detailImageUrl;
    String categoryId;
    Timestamp dateCraeted;
    String lastEdit;
    String categoryName;
    String action;
    String idName;
    String image1;

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String[] getDetailImageUrl() {
        return detailImageUrl;
    }

    public void setDetailImageUrl(String[] detailImageUrl) {
        this.detailImageUrl = detailImageUrl;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSelPrice() {
        return selPrice;
    }

    public void setSelPrice(double selPrice) {
        this.selPrice = selPrice;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Timestamp getDateCraeted() {
        return dateCraeted;
    }

    public void setDateCraeted(Timestamp dateCraeted) {
        this.dateCraeted = dateCraeted;
    }

    public String getLastEdit() {
        return lastEdit;
    }

    public void setLastEdit(String lastEdit) {
        this.lastEdit = lastEdit;
    }


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
