package com.icaropaixao.workshopmongo.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;


    // classe para retornar o Erro
    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
    
    public StandardError(Long timestamp, Integer status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;

    }


}
