package com.acn.nemo.service.impl;

import com.acn.nemo.model.Employee;
import com.acn.nemo.service.EmployeeService;

import java.util.Collections;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    /**
     * @return
     */
    @Override
    public List<Employee> retriveAllEmployee() {
        return Collections.emptyList();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Employee retriveEmployeeById(Long id) {
        return null;
    }
}
