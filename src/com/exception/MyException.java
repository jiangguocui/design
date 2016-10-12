package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * 抛出一个自定义规范的异常，包含错误信息erroMessage,http status, response headers
 * <p>Title: Module Information         </p>
 * <p>Description: Function Description </p>
 * <p>Copyright: Copyright (c) 2016     </p>
 * <p>Company: ND Co., Ltd.       </p>
 * <p>Create Time: 2016年10月12日           </p>
 * @author Administrator
 * <p>Update Time:                      </p>
 * <p>Updater:                          </p>
 * <p>Update Comments:                  </p>
 */
public class MyException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    ResponseEntity<ErrorMessage> responseEntity;

    public MyException(ResponseEntity<ErrorMessage> responseEntity, Throwable throwable) {
        super(responseEntity.getBody().getMessage(), throwable);
        this.responseEntity = responseEntity;
    }

    public MyException(ResponseEntity<ErrorMessage> responseEntity) {
        this(responseEntity, null);
    }

    public MyException(ErrorMessage errorMessage, HttpStatus status, Throwable throwable) {
        this(new ResponseEntity<>(errorMessage, status), throwable);
    }

    public MyException(ErrorMessage errorMessage, HttpStatus status) {
        this(new ResponseEntity<>(errorMessage, status));
    }

    public MyException(String code, String message, String detail, HttpStatus status, Throwable throwable) {
        this(new ErrorMessage(code, message, detail), status, throwable);
    }

    public MyException(String code, String message, String detail, HttpStatus status) {
        this(new ErrorMessage(code, message, detail), status, null);
    }

    public MyException(String code, String message, HttpStatus status, Throwable throwable) {
        this(new ErrorMessage(code, message), status, throwable);
    }

    public MyException(String code, String message, HttpStatus status) {
        this(code, message, status, null);
    }

    public MyException(String code, String message, Throwable throwable) {
        this(new ErrorMessage(code, message), HttpStatus.INTERNAL_SERVER_ERROR, throwable);
    }

    public MyException(String code, String message) {
        this(code, message, (Throwable) null);
    }
}
