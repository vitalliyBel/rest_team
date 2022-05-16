package com.teamA.spring.rest.exception_handling;

//класс ответственный за эксепшн некорректного айди
public class NoSuchEmployeeException extends RuntimeException{

    //переопределяем метод рантаймэксепшена
    public NoSuchEmployeeException(String message) { //будем передавать сообщение
        super(message);
    }
}