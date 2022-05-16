package com.teamA.spring.rest.controller;

import com.teamA.spring.rest.entity.Employee;
import com.teamA.spring.rest.exception_handling.EmployeeIncorrectData;
import com.teamA.spring.rest.exception_handling.NoSuchEmployeeException;
import com.teamA.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Класс управляет рест запросами и ответами
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    //Выводим список всех участников команды
    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    //Выводим участника команды по id
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) { //PathVariable это получение переменной из адреса запроса

        Employee employee = employeeService.getEmployee(id); //В id передается эта переменная

        if (employee == null) { //Делаем, чтобы при несуществующем id или null, выдавало, что искомого участника нет
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in Database");
        }
        return employee; //В тело ответа поместится не сам объект, а json этого объекта (благодаря jackson)
    }
}
