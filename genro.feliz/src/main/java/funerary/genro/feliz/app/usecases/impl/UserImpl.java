package funerary.genro.feliz.app.usecases.impl;

import funerary.genro.feliz.app.models.responses.AuthenticationResponse;
import funerary.genro.feliz.app.models.responses.UserInfoResponse;
import funerary.genro.feliz.app.usecases.UserGateway;
import funerary.genro.feliz.auth.repositories.UserRepository;
import funerary.genro.feliz.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserGateway {

    private final UserRepository repository;

    public UserImpl(UserRepository repository){

        this.repository = repository;
    }
    @Override
    public UserInfoResponse userInfo(String login) {
        User user = repository.findUserByLogin(login).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        return new UserInfoResponse(user.getCpf(), user.getFirstName(), user.getLastName(), user.getLogin(),  user.getDataNascimento());
    }
}
