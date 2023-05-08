package ru.skypro.ru.skyproHom2_7_Collections.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.ru.skyproHom2_7_Collections.emp.Employee;
import ru.skypro.ru.skyproHom2_7_Collections.service.EmployeeService;


import java.util.Collection;
@RequestMapping
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName){
        return employeeService.add(firstName, lastName);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName){
        return employeeService.add(firstName, lastName);
    }
    @GetMapping("/add")
    public Collection<Employee> findAll(){
        return employeeService.findAll();
    }
}
