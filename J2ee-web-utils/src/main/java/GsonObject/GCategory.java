package GsonObject;

import core.CategoryDTO;

import java.util.List;

public class GCategory {

    private boolean type;
    private String eCatName;
    private String cError;
    private String msg;

    List<CategoryDTO> categories;

    private GCategory(GCategoryBuilder gCategoryBuilder) {
        this.type = gCategoryBuilder.type;
        this.eCatName = gCategoryBuilder.eCatName;
        this.cError = gCategoryBuilder.cError;
        this.msg = gCategoryBuilder.msg;
        categories = gCategoryBuilder.categories;
    }

    public static class GCategoryBuilder {
        private boolean type;
        private String eCatName;
        private String cError;
        private String msg;
        List<CategoryDTO> categories;

        public GCategory build(){
            return new GCategory(this);
        }

        public GCategoryBuilder setType(boolean type) {
            this.type = type;
            return this;
        }

        public GCategoryBuilder setECatName(String eCatName) {
            this.eCatName = eCatName;
            return this;
        }

        public GCategoryBuilder setcError(String cError) {
            this.cError = cError;
            return this;
        }


        public GCategoryBuilder setMsg(String msg) {
            this.msg = msg;
            return this;
        }

        public GCategoryBuilder setCategories(List<CategoryDTO> categories) {
            this.categories = categories;
            return this;
        }

    }

    public boolean isType() {
        return type;
    }

    public String getECatName() {
        return eCatName;
    }

    public String getcError() {
        return cError;
    }

    public String getMsg() {
        return msg;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

}
