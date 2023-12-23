package com.pg.demo.sqllite.dao;

import com.pg.demo.sqllite.entity.Employee;

public interface EmployeeDao {

    public Employee saveEmployee(Employee emp);
    public Employee findEmpById(Long id);
}
