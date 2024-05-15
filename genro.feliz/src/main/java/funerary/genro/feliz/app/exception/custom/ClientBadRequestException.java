package funerary.genro.feliz.app.exception.custom;

public class ClientBadRequestException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ClientBadRequestException(String message){ super(message); }
}
