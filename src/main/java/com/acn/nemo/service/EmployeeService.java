package com.acn.nemo.service;

import com.acn.nemo.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> retriveAllEmployee();

    Employee retriveEmployeeById(Long id);
}
