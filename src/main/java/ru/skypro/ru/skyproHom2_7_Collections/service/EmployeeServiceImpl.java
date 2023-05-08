package ru.skypro.ru.skyproHom2_7_Collections.service;

import org.springframework.stereotype.Service;
import ru.skypro.ru.skyproHom2_7_Collections.emp.Employee;
import ru.skypro.ru.skyproHom2_7_Collections.exceptions.EmployeeAlreadyAddedException;
import ru.skypro.ru.skyproHom2_7_Collections.exceptions.EmployeeNotFoundException;
import ru.skypro.ru.skyproHom2_7_Collections.exceptions.EmployeeStorageIsFullException;


import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private  static  final  int Employees_MAX_Count=5;
    private final Map<String, Employee> employees;
    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee=new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())){
            throw new EmployeeAlreadyAddedException(employee);
        }
        if(employees.size()==Employees_MAX_Count){
            throw new EmployeeStorageIsFullException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee=new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())){
            throw new EmployeeNotFoundException(employee);
        }
        return employees.remove(employee.getFullName());
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee=new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException(employee);
        }
        return employees.get(employee.getFullName());
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
