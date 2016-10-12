package com.exception;

import java.io.Serializable;

/**
 * 错误信息封装类
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
public class ErrorMessage implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String code;
    private String message;
    private String detail;
    private ResponseErrorMessage cause;
    
    public ErrorMessage() {
    }

    public ErrorMessage(String code) {
        this(code, null, null);
    }

    public ErrorMessage(String code, String message) {
        this(code, message, null);
    }

    public ErrorMessage(String code, String message, String detail) {
        this(code, message, detail, null);
    }

    public ErrorMessage(String code, String message, String detail, ResponseErrorMessage cause) {
        this.message = message;
        this.code = code;
        this.detail = detail;
        this.cause = cause;
    }

    
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    public ResponseErrorMessage getCause() {
        return cause;
    }
    public void setCause(ResponseErrorMessage cause) {
        this.cause = cause;
    }

}
