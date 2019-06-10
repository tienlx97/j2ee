package logger;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import both.ServerLogDTO;
import utils.UrlPatternUtils;
import java.util.Enumeration;
import java.util.Map;
import java.util.HashMap;
public class Logger_Server {

    private static String handleRequest(HttpServletRequest req){

        Enumeration<String> parameterNames = req.getParameterNames();
        String parameter="";
        while (parameterNames.hasMoreElements()) {

            String paramName = parameterNames.nextElement();
            parameter=parameter+paramName+": ";

            String[] paramValues = req.getParameterValues(paramName);
            for (int i = 0; i < paramValues.length; i++) {
                String paramValue = paramValues[i];
                if((i+1)>= paramValues.length)
                    parameter=parameter+ paramValue;
                else
                    parameter=parameter+ paramValue+", ";
            }
            parameter=parameter+"; ";
        }

       return parameter;

    }
public static ServerLogDTO saveServerLog(HttpServletRequest req, String user,String type){
    if(UrlPatternUtils.hasServlet(req)){
        String method=req.getMethod();
        String parameter=handleRequest(req);
        String pathinfo=req.getPathInfo();
        String serverlet=req.getServletPath();

        if(pathinfo!=null){
            serverlet+=pathinfo;
        }
        String action=serverlet;
        return new ServerLogDTO(user,action,type,parameter,method);
    }
    return null;
}
}