package ru.skypro.ru.skyproHom2_7_Collections.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.skypro.ru.skyproHom2_7_Collections.emp.Employee;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(Employee employee){
        super("Сотрудник не найден: "+ employee.toString());
    }
}

