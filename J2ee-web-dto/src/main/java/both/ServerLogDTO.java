package both;

public class ServerLogDTO {
    public int getId() {
        return id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    private String method;
    public ServerLogDTO(){
        this.user = "";
        this.action = "";
        this.type = "";
        this.parameter = "";
        this.method="";
        this.time="";
    }
    public ServerLogDTO(String user, String action, String type, String parameter,String method) {
        this.user = user;
        this.action = action;
        this.type = type;
        this.parameter = parameter;
        this.method=method;
        this.time="";
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    private int id;
    private String user;
    private String action;
    private String type;
    private String parameter;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String time;
}
