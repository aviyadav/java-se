package com.sample.stream;

import java.util.List;
import java.util.Objects;

public class EmployeeRepository {
    private List<Employee> empList;

    public EmployeeRepository(List<Employee> empList) {
        this.empList = empList;
    }
    
    public Employee findById(Integer id) {
        for (Employee employee : empList) {
            if(Objects.equals(employee.getId(), id)) {
                return employee;
            }
        }
        
        return null;
    }
}
