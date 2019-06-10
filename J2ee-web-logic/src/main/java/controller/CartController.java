package controller;

import Constant.UrlConstant;
import Constant.VariableConstant;
import GsonObject.GCart;
import GsonObject.JSONCart;
import both.UserAccount;
import com.google.gson.Gson;
import core.ICartService;
import core.ProductDTO;
import model.CartDetailModel;
import utils.Ajax;
import utils.SessionHelper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = "/cart")
public class CartController extends HttpServlet {

    @Inject
    ICartService iCartService;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserAccount user = SessionHelper.getLoginedUserCustomer(request.getSession(false));
        if (user != null) {
            System.out.println("name "+user.getUserName());
            request.setAttribute("name", user.getUserName());
            request.getRequestDispatcher("/views/client/cart.jsp").forward(request, response);
            return;
        }
        request.setAttribute("name", "");
        request.getRequestDispatcher("/views/client/cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");
        String cv = request.getParameter("cv");

        if(type.equals("load")){
            UserAccount user = SessionHelper.getLoginedUserCustomer(request.getSession(false));

            GCart gCart = null;
            List<CartDetailModel> models = new ArrayList<>();
            if(user != null) {
                String cartId = iCartService.getCartId(user.getId());
                 models = iCartService.loadCart(user.getId());

            }  else {
                Gson gson = new Gson();
                List<JSONCart> jsonCart = new ArrayList<JSONCart>();

                if(!cv.equals("")) {
                    jsonCart = Arrays.asList(gson.fromJson(cv, JSONCart[].class));
                }

                models = iCartService.loadCart(jsonCart);

            }

            gCart = new GCart.GCartBuilder().setType(true).setCartDetail(models).build();
            Ajax.sendData(response,gCart);

        } else if(type.equals("cal")) {
            UserAccount user = SessionHelper.getLoginedUserCustomer(request.getSession(false));
            GCart gCart = null;

            if(user != null) {
                boolean rs = iCartService.OrderProduct(user.getId());
                if(rs == true) {
                    gCart = new GCart.GCartBuilder().setType(true).build();
                    Ajax.sendData(response,gCart);
                } else {
                    gCart = new GCart.GCartBuilder().setType(false).build();
                    Ajax.sendData(response,gCart);
                }
            }  else {
                gCart = new GCart.GCartBuilder().setType(false).build();
                Ajax.sendData(response,gCart);
            }
        } else if(type.equals("del")){
            UserAccount user = SessionHelper.getLoginedUserCustomer(request.getSession(false));
            GCart gCart = null;
            List<CartDetailModel> models = new ArrayList<>();
            String id = request.getParameter("id");

            if(user != null) {
                boolean rs = iCartService.RemoveCart(user.getId(),id);
                if(rs == true) {
                    String cartId = iCartService.getCartId(user.getId());
                    models = iCartService.loadCart(user.getId());
                    gCart = new GCart.GCartBuilder().setType(false).setCartDetail(models).build();
                }
            } else {
                Gson gson = new Gson();
                List<JSONCart> jsonCart = new ArrayList<JSONCart>();

                if(!cv.equals("")) {
                    jsonCart = Arrays.asList(gson.fromJson(cv, JSONCart[].class));
                }
                int pos = -1;
                for(int i=0; i< jsonCart.size(); i++) {
                    if(jsonCart.get(i).getId().equals(id)) {
                        pos = i;
                        break;
                    }
                }

                List<JSONCart> jsonCart2 = new ArrayList<JSONCart>(jsonCart);
                jsonCart2.remove(pos);

                models = iCartService.loadCart(jsonCart2);
                gCart = new GCart.GCartBuilder().setType(true).setCartDetail(models).setCarts(jsonCart2).build();
            }


            Ajax.sendData(response,gCart);

        } else if(type.equals("update")) {
            UserAccount user = SessionHelper.getLoginedUserCustomer(request.getSession(false));
            GCart gCart = null;
            List<CartDetailModel> models = new ArrayList<>();
            String qua = request.getParameter("qua");
            String id = request.getParameter("id");

            if(user!=null){
                boolean rs = iCartService.UpdateCart(user.getId(),id,Integer.parseInt(qua));
                if(rs == true) {
                    String cartId = iCartService.getCartId(user.getId());
                    models = iCartService.loadCart(user.getId());
                    gCart = new GCart.GCartBuilder().setType(false).setCartDetail(models).build();
                } else {

                }
            } else {
                Gson gson = new Gson();
                List<JSONCart> jsonCart = new ArrayList<JSONCart>();

                if(!cv.equals("")) {
                    jsonCart = Arrays.asList(gson.fromJson(cv, JSONCart[].class));
                }

                for(int i=0; i< jsonCart.size(); i++) {
                    if(jsonCart.get(i).getId().equals(id)) {
                        jsonCart.get(i).setQual(Integer.parseInt(qua));
                    }
                }
                models = iCartService.loadCart(jsonCart);
                gCart = new GCart.GCartBuilder().setType(true).setCartDetail(models).setCarts(jsonCart).build();
            }


                 Ajax.sendData(response,gCart);
        }

//        request.getRequestDispatcher("/views/client/cart.jsp").forward(request, response);
    }

}
