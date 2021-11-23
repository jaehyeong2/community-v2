package jaefactory.newboard.handler;


import jaefactory.newboard.handler.exception.CustomValidationException;
import jaefactory.newboard.util.Script;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomValidationException.class)
    public String validationException(CustomValidationException e) {

        return Script.back(e.getErrorMap().toString());
//        return new CommonResDto<Map<String,String>>(-1,e.getMessage(),e.getErrorMap()); // 에러 상황 => statusCode -1
    }
}
