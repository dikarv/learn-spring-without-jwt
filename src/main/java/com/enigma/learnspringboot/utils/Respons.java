package com.enigma.learnspringboot.utils;


import lombok.*;


//@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Respons <T>{//type data general atau generic
    //custom exception
    private String message;
    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
