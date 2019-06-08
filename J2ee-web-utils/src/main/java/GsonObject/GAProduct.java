package GsonObject;
import core.ProductDTO;
public class GAProduct {
    private boolean type;
    private ProductDTO dto;
    String msg;

    public String getMsg() {
        return msg;
    }

    private GAProduct(GAProductBuilder gaProductBuilder) {
        this.type = gaProductBuilder.type;
        this.dto = gaProductBuilder.dto;
        this.msg = gaProductBuilder.msg;
    }

    public static class GAProductBuilder {
        private boolean type;
        private ProductDTO dto;
        private String msg;

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
}
