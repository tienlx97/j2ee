package GsonObject;
import core.CategoryDTO;
import core.ProductDTO;

import java.util.List;

public class GAProduct {
    private boolean type;
    private ProductDTO dto;
    String msg;
    List<ProductDTO> products;

    public String getMsg() {
        return msg;
    }

    private GAProduct(GAProductBuilder gaProductBuilder) {
        this.type = gaProductBuilder.type;
        this.dto = gaProductBuilder.dto;
        this.msg = gaProductBuilder.msg;
        this.products = gaProductBuilder.products;
    }

    public static class GAProductBuilder {
        private boolean type;
        private ProductDTO dto;
        private String msg;
        private  List<ProductDTO> products;

        public GAProductBuilder setProducts(List<ProductDTO> products) {
            this.products = products;
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
