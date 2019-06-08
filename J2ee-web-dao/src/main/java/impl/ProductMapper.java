package impl;

import core.CategoryModel;
import model.ProductModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper {
    public ProductModel loadProducts(ResultSet rs){
        try {
            ProductModel productModel = new ProductModel();
            productModel.setId(rs.getString("prd_id"));
            productModel.setName(rs.getString("prd_name"));
            productModel.setSelPrice(rs.getDouble("prd_price"));
            productModel.setQuantity(rs.getInt("prd_quantity"));
            return productModel;
        } catch (SQLException e) {
            return null;
        }
    }

    public ProductModel loadProducts2View(ResultSet rs){
        try {
            ProductModel productModel = new ProductModel();
            productModel.setId(rs.getString("prd_id"));
            productModel.setQuantity(rs.getInt("prd_quantity"));

            productModel.setName(rs.getString("prd_name"));
            productModel.setSelPrice(rs.getDouble("prd_price"));
            productModel.setImageUrl(rs.getString("prd_image"));
            productModel.setDescription(rs.getString("prd_description"));
            productModel.setDateCraeted(rs.getTimestamp("prd_created_at"));
            productModel.setDetailImageUrl(rs.getString("prd_detail_images"));
            productModel.setCategoryName(rs.getString("cat_name"));

            return productModel;
        } catch (SQLException e) {
            return null;
        }
    }
}
