package com.ryanandvinicius.bomsomapp.fakeDatabase;
import com.ryanandvinicius.bomsomapp.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo {
    private List<Employee> employeeList;

    public EmployeeRepo(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        if (employee != null){
            employeeList.add(employee);
        }
    }

    public void editEmployee(Employee employee){
        if (employee != null){
            int index = findById(employee.getCpf());
            if (index >= 0){
                employeeList.add(index,employee);
            }
        }
    }

    private int findById(String id){
        for (int i = 0; i < employeeList.size(); i++){
            Employee e = employeeList.get(i);
            if (e.getCpf().trim().equals(id.trim())){
                return i;
            }
        }
        return -1;
    }
}
