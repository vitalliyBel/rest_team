package com.teamA.spring.rest.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //когда один класс отвечает за обработку исключений всех контроллеров(advice из АОП)
public class EmployeeGlobalExceptionHandler {
    //обработчик эксепшина(перегруженные методы handleException с разными параметрами)
// тут если вместо айди пишем несуществующий номер айди
    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleException(
            NoSuchEmployeeException exception){ //тут NoSuch.. текст для него написали в MyRestControllere
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
    //тут для любых других данных вместо айди(abc(NumberFormatExc), и тд )
    @ExceptionHandler
    public ResponseEntity <EmployeeIncorrectData>handleException(
            Exception exception) { //а тут остальные эксепшены
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}