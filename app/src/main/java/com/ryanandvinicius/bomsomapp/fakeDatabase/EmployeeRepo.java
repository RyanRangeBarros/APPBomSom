package com.ryanandvinicius.bomsomapp.fakeDatabase;
import com.ryanandvinicius.bomsomapp.model.Client;
import com.ryanandvinicius.bomsomapp.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo {
    private static List<Employee> employeeList;

    static {
        employeeList = new ArrayList<>();
    }

    public static void addEmployee(Employee employee){
        if (employee != null){
            employeeList.add(employee);
        }
    }

    public static void editEmployee(Employee employee){
        if (employee != null){
            int index = findById(employee.getCpf());
            if (index >= 0){
                employeeList.add(index,employee);
            }
        }
    }

    public static int findById(String id){
        for (int i = 0; i < employeeList.size(); i++){
            Employee e = employeeList.get(i);
            if (e.getCpf().trim().equals(id.trim())){
                return i;
            }
        }
        return -1;
    }



    public static Employee find(String id){
        for (Employee e: employeeList){
            if (e.getCpf().trim().equals(id.trim())){
                return e;
            }
        }
        return null;
    }


    public static List<String> getAllNames(){
        List<String> names = new ArrayList<>();

        for (Employee e: employeeList){
            names.add(e.getName());
        }
        return names;
    }

}
