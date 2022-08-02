package br.com.rodrigovargas.crudcrm.model.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
//public class StandardError extends RuntimeException {
public class StandardError {

    private LocalDateTime timeStamp;
    private Integer status;
    private String error;
    private String path;

}
