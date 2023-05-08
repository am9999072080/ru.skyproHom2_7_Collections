package ru.skypro.ru.skyproHom2_7_Collections.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.skypro.ru.skyproHom2_7_Collections.emp.Employee;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException (Employee employee){
        super("Такой сотрудник уже существует" + employee.toString());
    }

}
