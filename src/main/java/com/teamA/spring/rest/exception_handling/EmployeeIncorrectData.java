package com.teamA.spring.rest.exception_handling;

//просто класс некоррект айди с гетт и сеттер
public class EmployeeIncorrectData {
    private String info;

    public EmployeeIncorrectData() {
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}