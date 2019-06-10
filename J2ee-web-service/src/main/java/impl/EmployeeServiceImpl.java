package impl;

import BeanUtils.FunctionBeanUtil;
import BeanUtils.EmployeeBeanUtil;
import both.FunctionRole;
import both.ServerLogDTO;
import core.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.util.Random;
@Default
public class EmployeeServiceImpl implements IEmployeeService {

    @Inject
    private IEmployeeDAO iEmployeeDAO;

    public EmployeeDTO checkEmployeeLogin(EmployeeDTO employeeDTO) {
        EmployeeModel employeeModel = EmployeeBeanUtil.convert2ModelLoginPage(employeeDTO);
        iEmployeeDAO = new EmployeeDAOImpl();
        employeeModel=iEmployeeDAO.checkEmployeeLogin(employeeModel);
        if(employeeModel==null) {
            return null;
        }
        return EmployeeBeanUtil.convert2DTO(employeeModel, iEmployeeDAO.getRoles(employeeModel));

    }

    public List<EmployeeDTO> getAllEmployee(){
        iEmployeeDAO = new EmployeeDAOImpl();
        List<EmployeeModel> employeeModel=iEmployeeDAO.getAllEmployee();
        List<EmployeeDTO> employeeDTO= new ArrayList<EmployeeDTO>();
        for(EmployeeModel i : employeeModel){
            employeeDTO.add(EmployeeBeanUtil.convert2DTO(i,iEmployeeDAO.getRoles(i)));
        }
        return employeeDTO;
    }
    public List<FunctionRole> getAllFunctionRole(){
        iEmployeeDAO = new EmployeeDAOImpl();
        List<FunctionRoleModel> functionRoleModelList=iEmployeeDAO.getAllFunctionRole();
        List<FunctionRole> functionRoleList= new ArrayList<FunctionRole>();
        for(FunctionRoleModel i : functionRoleModelList){
            functionRoleList.add(FunctionBeanUtil.convert2DTO(i));
        }
        return functionRoleList;
    }

    public EmployeeDTO getEmployeeById(int id) {
        iEmployeeDAO = new EmployeeDAOImpl();
        EmployeeModel employeeModel=iEmployeeDAO.getEmployeeById(id);
        if(employeeModel==null) {
            return null;
        }
        return EmployeeBeanUtil.convert2DTO(employeeModel, iEmployeeDAO.getRoles(employeeModel));
    }
    public String getNewPassword(String id) {
        iEmployeeDAO = new EmployeeDAOImpl();

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String password = buffer.toString();
        String result=iEmployeeDAO.saveNewPassword(id,password);
        if(!result.equals("1")) {
            return "0";
        }
        return password;
    }

    public String activeEmployee(String id) {
        iEmployeeDAO = new EmployeeDAOImpl();
        return iEmployeeDAO.activeEmployee(id);
    }

    public String disableEmployee(String id) {
        iEmployeeDAO = new EmployeeDAOImpl();
        return iEmployeeDAO.disableEmployee(id);
    }

    public String removeEmployee(String id) {
        iEmployeeDAO = new EmployeeDAOImpl();
        return iEmployeeDAO.removeEmployee(id);
    }
    public String updateEmployee(EmployeeDTO employeeDTO,String dob,String roles) {
        EmployeeModel employeeModel = EmployeeBeanUtil.convert2ModelLoginPage(employeeDTO);
        iEmployeeDAO = new EmployeeDAOImpl();
        List<String> rolesCur=iEmployeeDAO.getRoles(employeeModel);
        String[] rolesNew=roles.split("-");
        List<String> rolesNewList=new ArrayList<>();
        for(String role : rolesNew){
            rolesNewList.add(role);
            if(!rolesCur.contains(role)){
                String result=iEmployeeDAO.addEmployeeRole(employeeModel.getId(),role);
            }
        }

        for(String role : rolesCur){
            if(!rolesNewList.contains(role)){
                String result=iEmployeeDAO.removeEmployeeRole(employeeModel.getId(),role);
            }
        }
        return iEmployeeDAO.updateEmployee(employeeModel,dob);
    }

    public List<EmployeeDTO> getAllEmployeeBySearch(String id,String name, String date_to,String date_from){
        iEmployeeDAO = new EmployeeDAOImpl();
        List<EmployeeModel> models = iEmployeeDAO.getAllEmployeeBySearch(id,name,date_to,date_from);
        List<EmployeeDTO> dtos = new ArrayList<>();
        for (int i=0; i< models.size(); i++) {
            EmployeeDTO dto = EmployeeBeanUtil.convert2DTO(models.get(i),iEmployeeDAO.getRoles(models.get(i)));
            dtos.add(dto);
        }
        return  dtos;
    }
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO,String dob,String roles){
        EmployeeModel employeeModel = EmployeeBeanUtil.convert2ModelLoginPage(employeeDTO);
        iEmployeeDAO = new EmployeeDAOImpl();
        String id= iEmployeeDAO.addEmployee(employeeDTO,dob);
        if(!id.equals("0")) {
            List<String> roleEmp = new ArrayList<>();
            String[] rolesNew = roles.split("-");
            for (String role : rolesNew) {
                roleEmp.add(role);
                String result = iEmployeeDAO.addEmployeeRole(id, role);
            }
            employeeDTO.setRoles(roleEmp);
            return employeeDTO;
        }
        else{
            return null;
        }
    }

}
