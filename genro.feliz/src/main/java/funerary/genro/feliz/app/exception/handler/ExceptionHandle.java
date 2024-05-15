package funerary.genro.feliz.app.exception.handler;

import funerary.genro.feliz.app.exception.custom.ClientBadRequestException;
import funerary.genro.feliz.app.exception.custom.ClientNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import funerary.genro.feliz.app.exception.model.PadraoErro;
import funerary.genro.feliz.app.exception.model.ValidationError;

public class ExceptionHandle {


    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<PadraoErro> ClientNotFoundException(ClientNotFoundException exception, HttpServletRequest request){
        return erroPadronizado(HttpStatus.NOT_FOUND, "Nenhum Objeto retornado!", exception, request);
    }

    @ExceptionHandler(ClientBadRequestException.class)
    public ResponseEntity<PadraoErro> ClientBadRequestException(ClientBadRequestException exception, HttpServletRequest request){
        return erroPadronizado(HttpStatus.BAD_REQUEST, "Nenhum resultado retornado!", exception, request);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<PadraoErro> validationException(MethodArgumentNotValidException error, HttpServletRequest request) {

        ValidationError validationError = new ValidationError(System.currentTimeMillis(),
                HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de Validação de Campos!",
                error.getMessage(), request.getRequestURI());

        error.getBindingResult().getFieldErrors().forEach(fieldError -> validationError.addError(
                fieldError.getField(), fieldError.getDefaultMessage()));

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(validationError);
    }

    private ResponseEntity<PadraoErro> erroPadronizado(HttpStatus httpStatus, String mensagemGenericaErro,
                                                       Exception exception, HttpServletRequest request) {

        return ResponseEntity.status(httpStatus).body(new PadraoErro(System.currentTimeMillis(), httpStatus.value(),
                mensagemGenericaErro, exception.getMessage(), request.getRequestURI()));
    }


}
