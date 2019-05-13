package both;

import java.util.ArrayList;
import java.util.List;

public class UserAccount {

    enum TYPEUSER {
        EMPLOYEE,
        CUSTOMER
    }

    private String userName;
    private TYPEUSER TypeUser;
    private List<String> roles;

    public UserAccount(String userName, List<String> roles) {
        this.userName = userName;

        if (roles == null) {
            TypeUser = TYPEUSER.CUSTOMER;
            List<String> role = new ArrayList<String>();
            role.add("FUNC_0");
            this.roles = role;
        } else {
            this.roles=new ArrayList<String>();
            TypeUser = TYPEUSER.EMPLOYEE;
            for(String role : roles){
                this.roles.add("FUNC_"+role);
            }
        }
    }


    public TYPEUSER getTypeUser() {
        return TypeUser;
    }

    public void setTypeUser(TYPEUSER typeUser) {
        TypeUser = typeUser;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

}
