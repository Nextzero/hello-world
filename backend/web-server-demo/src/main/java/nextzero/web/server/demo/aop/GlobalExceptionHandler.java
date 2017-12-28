package nextzero.web.server.demo.aop;

import nextzero.web.server.demo.entity.BaseResponse;
import nextzero.web.server.demo.entity.ErrorType;
import nextzero.web.server.demo.util.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.List;
import java.util.Set;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Focus on handling ValidationException
     *
     * @param exception exception
     * @return ErrorResp
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public BaseResponse exception(MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        final StringBuilder strBuilder = new StringBuilder();
        for (FieldError fieldError : fieldErrors) {
            if (strBuilder.length() > 1) {
                strBuilder.append("|");
            }
            strBuilder.append(fieldError.getDefaultMessage());
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("invalidValue info : {}", strBuilder.toString());
        }

        return ResponseUtils.fail(ErrorType.INNER_ERROR);
    }

    /**
     * Focus on handling ValidationException
     *
     * @param exception exception
     * @return ErrorResp
     */
    @ExceptionHandler(value = ValidationException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public BaseResponse exception(ValidationException exception) {
        if (exception instanceof ConstraintViolationException) {
            ConstraintViolationException constraintViolationException = (ConstraintViolationException) exception;
            Set<ConstraintViolation<?>> set = constraintViolationException.getConstraintViolations();
            final StringBuilder strBuilder = new StringBuilder();
            for (ConstraintViolation<?> invalidValue : set) {
                if (strBuilder.length() > 1) {
                    strBuilder.append("|");
                }
                strBuilder.append(invalidValue.getMessage());
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("invalidValue info : {}", strBuilder.toString());
            }
        }
        return ResponseUtils.fail(ErrorType.INNER_ERROR);
    }

    /**
     * Focus on handling jetty EofException
     *
     * @param exception exception
     * @return ErrorResp
     */
    @ExceptionHandler(value = HttpMessageConversionException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public BaseResponse exception(HttpMessageConversionException exception) {
        LOG.error("org.springframework.http.converter.HttpMessageConversionException: Can't read the document, Illegal json or xml format.");
        return ResponseUtils.fail(ErrorType.INNER_ERROR);
    }

    /**
     * Focus on handling Unexpected Global Exception
     *
     * @param exception exception
     * @return ErrorResp
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public BaseResponse exception(Exception exception) {
        LOG.error("Global Unexpected occur info : {}", exception);
        return ResponseUtils.fail(ErrorType.INNER_ERROR);
    }
}
