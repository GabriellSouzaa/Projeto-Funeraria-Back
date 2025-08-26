package funerary.genro.feliz.app.usecases;

import funerary.genro.feliz.app.models.responses.AuthenticationResponse;
import funerary.genro.feliz.app.models.responses.UserInfoResponse;

public interface UserGateway {

    UserInfoResponse userInfo(String nome);
}
