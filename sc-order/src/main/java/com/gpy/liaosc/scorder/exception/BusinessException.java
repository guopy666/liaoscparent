package com.gpy.liaosc.scorder.exception;

import com.gpy.liaosc.scorder.constant.ResultEnum;

/**
 * 数据中心业务异常
 * @author yzl
 * 201507
 */
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = -362824868473001444L;
	
	/** 错误代码 */
	private Integer exceptionCode;
	/** 错误原因 */
	private String exceptionMsg;

	public BusinessException() {
	}
	
	public BusinessException(String exceptionMsg){
		super(exceptionMsg);
		this.exceptionMsg = exceptionMsg;
	}

	public BusinessException(ResultEnum resultEnum){
	    this.exceptionCode = resultEnum.getValue();
	    this.exceptionMsg = resultEnum.getText();
    }

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public BusinessException(Integer exceptionCode, String exceptionMsg) {
		this.exceptionCode = exceptionCode ;
		this.exceptionMsg = exceptionMsg;
	}

	public Integer getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(Integer exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
}