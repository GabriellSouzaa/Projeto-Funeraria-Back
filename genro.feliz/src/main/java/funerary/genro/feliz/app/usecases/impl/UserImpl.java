package funerary.genro.feliz.app.usecases.impl;

import funerary.genro.feliz.app.models.responses.AuthenticationResponse;
import funerary.genro.feliz.app.usecases.UserGateway;
import funerary.genro.feliz.auth.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserGateway {

//    private final UserRepository repository;

    public UserImpl(){

    }
    @Override
    public AuthenticationResponse userInfo(String nome) {
        return null;
    }
}
