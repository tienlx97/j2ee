package impl;

import core.CategoryModel;
import model.CartDetailModel;
import model.CartModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartMapper {
    public String getCartId(ResultSet rs){
        try {
            return rs.getString("cart_id");
        } catch (SQLException e) {
            return null;
        }
    }

    public String getOrderProductId(ResultSet rs){
        try {
            return rs.getString("orp_id");
        } catch (SQLException e) {
            return null;
        }
    }

    public String getCartdetailId(ResultSet rs){
        try {
            return rs.getString("crd_id");
        } catch (SQLException e) {
            return null;
        }
    }

    public String getOrderCart(ResultSet rs){
        try {
            return rs.getString("orp_id");
        } catch (SQLException e) {
            return null;
        }
    }

    public int getPrdId(ResultSet rs) {
        try {
            return rs.getInt("crd_quantity");
        } catch (SQLException e) {
            return Integer.parseInt(null);
        }
    }

    public CartDetailModel getCart(ResultSet rs){
        try {
            CartDetailModel model = new CartDetailModel();

            model.setPrdId(rs.getString("crd_prd_id"));
            model.setQua(rs.getInt("crd_quantity"));
            model.setPrdName(rs.getString("prd_name"));
            model.setPrdPrice(rs.getDouble("prd_price"));
            model.setImage(rs.getString("prd_image"));
            model.calTotal();
            return model;
        } catch (SQLException e) {
            return null;
        }
    }
}
