package core;

import java.io.Serializable;

public class CategoryDTO implements Serializable {
    String catId;
    String catName;
    String catDescription;
    String catImgUrl;
    String catSearch;
    String action;
    public String getCatImgUrl() {
        return catImgUrl;
    }

    public void setCatImgUrl(String catImgUrl) {
        this.catImgUrl = catImgUrl;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatDescription() {
        return catDescription;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getCatSearch() {
        return catSearch;
    }

    public void setCatSearch(String catSearch) {
        this.catSearch = catSearch;
    }
}
