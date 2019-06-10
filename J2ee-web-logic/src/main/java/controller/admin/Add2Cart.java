package controller.admin;

import Constant.UrlConstant;
import GsonObject.GCart;
import GsonObject.JSONCart;
import both.UserAccount;
import com.google.gson.Gson;
import com.sun.deploy.util.StringUtils;
import core.ICartService;
import core.ProductDTO;
import utils.Ajax;
import utils.FormUtil;
import utils.SessionHelper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@WebServlet(urlPatterns = "/api/add2cart")
public class Add2Cart  extends HttpServlet {

    @Inject
    ICartService iCartService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserAccount user = SessionHelper.getLoginedUserCustomer(request.getSession(false));
        String id = request.getParameter("id");
        String qual = request.getParameter("qual");
        String cv = request.getParameter("cv");
        String mg = request.getParameter("mg");
        if (user != null) {

            if(mg != null) {
                Gson gson = new Gson();
                List<JSONCart> jsonCart = new ArrayList<JSONCart>();

                if(!cv.equals("")) {
                    jsonCart = Arrays.asList(gson.fromJson(cv, JSONCart[].class));
                }

                boolean rs = iCartService.mergeCart(user.getId(),jsonCart);

                if(rs == true) {
                    GCart gCart = new GCart.GCartBuilder().setType(true).build();
                    Ajax.sendData(response,gCart);
                } else {
                    GCart gCart = new GCart.GCartBuilder().setType(false).build();
                    Ajax.sendData(response,gCart);
                }
            }


            // save to database
            String customerId = user.getId();
            boolean rs = iCartService.AddItem2Cart(id,Integer.parseInt(qual),customerId);

            if(rs == true) {
                GCart gCart = new GCart.GCartBuilder().setType(true).build();
                Ajax.sendData(response,gCart);
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
                    jsonCart.get(i).setQualPlus(Integer.parseInt(qual));
                    GCart gCart = new GCart.GCartBuilder().setType(false).setCarts(jsonCart).build();
                    Ajax.sendData(response,gCart);
                    return;
                }
            }

            JSONCart item = new JSONCart(id, Integer.parseInt(qual));
            List<JSONCart> jsonCart2 = new ArrayList<JSONCart>(jsonCart);
            jsonCart2.add(item);
            GCart gCart = new GCart.GCartBuilder().setType(false).setCarts(jsonCart2).build();
            Ajax.sendData(response,gCart);
            return;

        }
    }

}
