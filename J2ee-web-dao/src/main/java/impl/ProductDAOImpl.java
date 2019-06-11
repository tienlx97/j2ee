package impl;

import core.AbstractDAO;
import core.CategoryModel;
import core.IProductDAO;
import model.ProductModel;

import java.util.List;

public class ProductDAOImpl extends AbstractDAO<ProductModel> implements IProductDAO {
    @Override
    public List<ProductModel> loadAllProducts(int f, int t) {
        StringBuilder query = new StringBuilder("SELECT prd_id, prd_name,prd_price, prd_quantity FROM j2_product ord ORDER BY prd_price limit ?, ?;");
        List<ProductModel> models = read2(query.toString(),ProductMapper.class,new ProductMapper(),"loadProducts",f,t);
        return models;
    }

    @Override
    public boolean updateProduct(ProductModel model) {
        StringBuilder query = new StringBuilder("UPDATE j2_product SET prd_name = ? , prd_description = ? , prd_price = ? , prd_quantity = ? , prd_image = ? , prd_detail_images = ? , prd_category = ? where prd_id = ? ;");
        boolean rs = update(query.toString(),model.getName(), model.getDescription(), model.getSelPrice(), model.getQuantity(), model.getImageUrl(), model.getDetailImageUrl(), model.getCategoryId(), model.getId());
        return rs;
    }

    @Override
    public boolean addProduct(ProductModel model) {
        StringBuilder query = new StringBuilder("INSERT INTO j2_product(prd_id,prd_name,prd_description,prd_price,prd_quantity,prd_category,prd_image,prd_detail_images,prd_created_at,prd_updated_at) values(?,?,?,?,?,?,?,?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)");
        boolean rs = create(query.toString(),model.getId(), model.getName(),model.getDescription(), model.getSelPrice(), model.getQuantity(), model.getCategoryId(), model.getImageUrl(), model.getDetailImageUrl());
        return rs;
    }


    @Override
    public List<ProductModel> searchProducts(String idName,int f, int t) {
        StringBuilder query = new StringBuilder("SELECT prd_id, prd_name,prd_price, prd_quantity FROM j2_product WHERE prd_id LIKE  ? OR prd_name LIKE ? ORDER BY prd_price limit ?, ?;;");
        List<ProductModel> models = read2(query.toString(),ProductMapper.class,new ProductMapper(),"loadProducts","%" + idName + "%", "%" + idName + "%", f,t);

        return models;
    }

    @Override
    public ProductModel getProduct2View(String id) {
        StringBuilder query = new StringBuilder("SELECT prd_id, prd_name,prd_price, prd_quantity, prd_image,prd_detail_images, prd_description, prd_created_at, j2_category.cat_name, prd_category  FROM j2_product, j2_category where prd_id = ? and j2_product.prd_category = j2_category.cat_id;");
        List<ProductModel> models = read2(query.toString(),ProductMapper.class,new ProductMapper(),"loadProducts2View",id);
        return models.isEmpty() ? null :  models.get(0);
    }

    @Override
    public int countProduct() {
        StringBuilder query = new StringBuilder("SELECT count(*) FROM j2_product;");
        return count(query.toString());
    }

    @Override
    public List<ProductModel> load12Products() {
        StringBuilder query = new StringBuilder("SELECT prd_id, prd_name, prd_image, prd_price from j2_product ORDER BY prd_price limit 0, 12");
        List<ProductModel> models = read2(query.toString(),ProductMapper.class,new ProductMapper(),"load12Product2View");
        return models;
    }
}
