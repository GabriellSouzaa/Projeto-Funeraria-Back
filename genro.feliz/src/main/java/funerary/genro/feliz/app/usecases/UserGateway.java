package funerary.genro.feliz.app.usecases;

import funerary.genro.feliz.app.models.responses.AuthenticationResponse;

public interface UserGateway {

    AuthenticationResponse userInfo(String nome);
}
