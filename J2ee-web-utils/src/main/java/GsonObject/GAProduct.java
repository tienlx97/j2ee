package GsonObject;
import core.CategoryDTO;
import core.ProductDTO;

import java.util.List;

public class GAProduct {
    private boolean type;
    private ProductDTO dto;
    String msg, error;
    int numberPage;
    List<ProductDTO> products;

    public String getMsg() {
        return msg;
    }
    public int getNumberPage() {
        return numberPage;
    }
    public String getError() {
        return error;
    }

    private GAProduct(GAProductBuilder gaProductBuilder) {
        this.type = gaProductBuilder.type;
        this.dto = gaProductBuilder.dto;
        this.msg = gaProductBuilder.msg;
        this.products = gaProductBuilder.products;
        this.error = gaProductBuilder.error;
        this.numberPage = gaProductBuilder.numberPage;
    }

    public static class GAProductBuilder {
        private boolean type;
        private ProductDTO dto;
        private String msg,error;
        int numberPage;
        private  List<ProductDTO> products;

        public GAProductBuilder setProducts(List<ProductDTO> products) {
            this.products = products;
            return this;
        }

        public GAProductBuilder setNumberPage(int n) {
            this.numberPage = n;
            return this;
        }

        public GAProductBuilder setError(String err) {
            this.error = err;
            return this;
        }

        public GAProductBuilder setMsg(String msg) {
            this.msg = msg;
            return this;
        }

        public GAProduct build(){
            return new GAProduct(this);
        }

        public GAProductBuilder setType(boolean type) {
            this.type = type;
            return this;
        }

        public GAProductBuilder setDto(ProductDTO dto) {
            this.dto = dto;
            return this;
        }

    }

    public boolean isType() {
        return type;
    }

    public ProductDTO getDto() {
        return dto;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }
}
