package com.conurets.EmployeeInformationSystem.dao;

import com.conurets.EmployeeInformationSystem.dto.DataTableRequestDTO;
import com.conurets.EmployeeInformationSystem.model.Employee;
import com.conurets.EmployeeInformationSystem.respository.EmployeeRepository;
import io.ebean.Ebean;
import io.ebean.EbeanServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class EmployeeDataAccessService implements IEmployeeDao {

    EbeanServer ebeanServer = Ebean.getServer("db");

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired EmployeeDataAccessService (EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee insertEmployee(Employee employee) {
        Timestamp createdDate = new Timestamp(System.currentTimeMillis());
        employee.setCreatedDate(createdDate);
        ebeanServer.save(employee);
        return employee;
    }

    @Override
    public List<Employee> selectAllEmployees() {
        return ebeanServer.find(Employee.class).findList();
    }

    @Override
    public List<Employee> listAllEmployees(DataTableRequestDTO dataTableRequestDTO) {
        /*List<OrderByDTO> orderByDTOs = new ArrayList<>();

        for(HashMap<String, String> orderBy: dataTableRequestDTO.getOrder())
        {
            String column = orderBy.get("column");
            String sortingType = orderBy.get("dir");

            OrderByDTO orderByDTO = new OrderByDTO(column, sortingType);

            orderByDTOs.add(orderByDTO);
        }

        String searchTerm = "";

        if(StringUtils.hasText(dataTableRequestDTO.getSearch().get("value")))
        {
            searchTerm = "%" + dataTableRequestDTO.getSearch().get("value") + "%";
        }*/

        /*List<EmployeeDAO> employeeDAOs = iDaoFactory.getEmployeeDAO().findAllDTOsForDataTable(orderByDTOs, dataTableRequestDTO.getStart(), dataTableRequestDTO.getLength(), searchTerm);*/

        return ebeanServer.find(Employee.class).findList();
    }

    @Override
    public Optional<Employee> selectEmployeeById(Integer id) {
        return Optional.ofNullable(Ebean.find(Employee.class, id));
    }

    @Override
    public List<Employee> deleteEmployeeById(Integer id) {
        Employee employee = Ebean.find(Employee.class, id);
        ebeanServer.delete(employee);
        return ebeanServer.find(Employee.class).findList();
    }

    @Override
    public Employee updateEmployeeById(Employee employee) {
        ebeanServer.update(employee);
        return employee;
    }

    /*public final JdbcTemplate jdbcTemplate;*/

    /*@Autowired
    public EmployeeDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }*/

     /* @Override
    public int insertEmployee(Employee employee) {
        *//*String sqlQuery = "INSERT INTO employee (id, name, role, cnic, age, dob) VALUES (?, ?, ?, ?, ?, ?)";
        int rowsAffected = jdbcTemplate.update(sqlQuery, UUID.randomUUID(), employee.getName(), employee.getRole(), employee.getCnic(), employee.getAge(), employee.getDob());
        return rowsAffected;*//*
    }*/

    /*@Override
    public List<Employee> selectAllPeople() {
        *//*List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee (UUID.randomUUID(), "FROM POSTGRES DB"));
        return employeeList;*//*

        String sqlQuery = "SELECT id, name, role, cnic, age, dob from employee";
        return jdbcTemplate.query(sqlQuery, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String role = resultSet.getString("role");
            String cnic = resultSet.getString("cnic");
            int age = resultSet.getInt("age");
            Date dob = resultSet.getDate("dob");

            return new Employee(id, name, role, cnic, age, dob);
        });
    }*/

    /*@Override
    public Optional<Employee> selectEmployeeById(UUID id) {
        final String sqlQuery = "SELECT id, name, role, cnic, age, dob FROM employee WHERE id = ?";

        Employee employee = jdbcTemplate.queryForObject(sqlQuery, new Object[]{id},
                (resultSet, i) -> {
                    UUID employeeId = UUID.fromString(resultSet.getString("id"));
                    String name = resultSet.getString("name");
                    String role = resultSet.getString("role");
                    String cnic = resultSet.getString("cnic");
                    int age = resultSet.getInt("age");
                    Date dob = resultSet.getDate("dob");

                    return new Employee(id, name, role, cnic, age, dob);
                });

        return Optional.ofNullable(employee);
    }*/

    /*@Override
    public List<Employee> deleteEmployeeById(UUID id) {
        String sqlQuery = "DELETE FROM employee WHERE id = ?";
        jdbcTemplate.update(sqlQuery, id);
        return selectAllPeople();
    }

    @Override
    public int updateEmployeeById(Employee employee) {
        String sqlQuery = "UPDATE employee SET name = ?, role = ?, cnic = ?, age = ?, dob = ? WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sqlQuery, employee.getName(), employee.getRole(), employee.getCnic(), employee.getAge(), employee.getDob(), employee.getId());
        return rowsAffected;
    }*/
}
