package utils;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Ajax {
    public static void sendData(HttpServletResponse resp, Object obj) throws IOException {
        Gson gson = new Gson();
        String response = gson.toJson(obj);
        PrintWriter out = resp.getWriter();
        try {
            out.println(response);
            out.flush();
        } finally {
            out.close();
        }
    }
}
