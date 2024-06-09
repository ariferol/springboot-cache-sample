package tr.com.sample.common.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tr.com.sample.common.base.ResponseDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException exception) {
        //TODO: Burada log modelini doldur;
        //ExceptionUtilBean.addExceptionLog(exception);
        return new ResponseEntity<Object>(ResponseDTO.Builder.newInstance()
                .data("Hata: " + exception.getMessage())
                .description("Calisma zamani hatasi, lutfen sistem yoneticisi ne basvurunuz")
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
