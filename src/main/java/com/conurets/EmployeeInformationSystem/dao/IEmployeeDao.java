package com.conurets.EmployeeInformationSystem.dao;

import com.conurets.EmployeeInformationSystem.dto.DataTableRequestDTO;
import com.conurets.EmployeeInformationSystem.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeDao {
    /*int insertEmployee(UUID id, Employee employee);

    default int insertEmployee(Employee employee) {
        UUID id = UUID.randomUUID();
        return insertEmployee(id, employee);
    }*/

    Employee insertEmployee(Employee employee);

    List<Employee> selectAllEmployees();

    List<Employee> listAllEmployees(DataTableRequestDTO dataTableRequestDTO);

    Optional<Employee> selectEmployeeById(Integer id);

    List<Employee> deleteEmployeeById(Integer id);

    Employee updateEmployeeById(Employee employee);
}
