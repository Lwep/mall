package com.leqi.admin.service.common;

import com.leqi.common.core.Result;
import com.leqi.common.enums.ResultCode;
import com.leqi.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Set;

/**
 * @author lwep
 * @dareTime 2019/9/27 9:57
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 通用异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public Result<Object> handleException(Exception e) {
        return Result.fail(ResultCode.SERVER_ERROR.getCode(),e.getMessage());
    }
    /**
     * 缺少请求参数
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.error("缺少请求参数", e);
        return Result.fail(ResultCode.PARAM_CHECK_ERROR.getCode(),"缺少请求参数"+ e.getMessage());
    }

    /**
     * 参数解析失败
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("参数解析失败", e);
        return Result.fail(ResultCode.PARAM_CHECK_ERROR.getCode(),"json数据格式不正确"+ e.getMessage());
    }

    /**
     * 参数验证
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("参数验证失败", e);
        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String field = error.getField();
        String code = error.getDefaultMessage();
        String message = String.format("%s:%s", field, code);
        return Result.fail(ResultCode.PARAM_CHECK_ERROR.getCode(),message);
    }

    /**
     * 参数校验异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public Result handleBindException(BindException e) {
        log.error("参数绑定失败", e);
        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String field = error.getField();
        String code = error.getDefaultMessage();
        String message = String.format("%s:%s", field, code);
        return Result.fail(ResultCode.PARAM_CHECK_ERROR.getCode(),message);
    }

    /**
     * 参数校验异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Result handleServiceException(ConstraintViolationException e) {
        log.error("参数验证失败", e);
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = violations.iterator().next();
        String message = violation.getMessage();
        return Result.fail(ResultCode.PARAM_CHECK_ERROR.getCode(),message);
    }

    /**
     * 参数验证异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public Result handleValidationException(ValidationException e) {
        log.error("参数验证失败", e);
        return Result.fail(ResultCode.PARAM_CHECK_ERROR.getCode(),e.getMessage());
    }

    /**
     *  不支持当前请求方法
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("不支持当前请求方法", e);
        return Result.fail(ResultCode.PARAM_CHECK_ERROR.getCode(),"请求方法不支持");
    }

    /**
     * 不支持当前媒体类型
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Result handleHttpMediaTypeNotSupportedException(Exception e) {
        log.error("不支持当前媒体类型", e);
        return Result.fail(ResultCode.PARAM_CHECK_ERROR.getCode(),"不支持当前媒体类型");
    }

    /**
     * 业务逻辑异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BusinessException.class)
    public Result handleServiceException(BusinessException e) {
        log.error("业务逻辑异常", e);
        return Result.fail(e.getMessage());
    }
    /**
     * 操作数据库出现异常:名称重复，外键关联
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public Result handleException(DataIntegrityViolationException e) {
        log.error("操作数据库出现异常:", e);
        return Result.fail("操作数据库出现异常：字段重复、有外键关联等");
    }
}
