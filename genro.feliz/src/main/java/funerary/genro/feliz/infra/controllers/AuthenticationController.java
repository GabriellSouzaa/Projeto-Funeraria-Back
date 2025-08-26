package funerary.genro.feliz.infra.controllers;

import funerary.genro.feliz.app.models.responses.AuthenticationResponse;
import funerary.genro.feliz.app.models.responses.LoginResponse;
import funerary.genro.feliz.app.models.requests.RegisterRequest;
import funerary.genro.feliz.app.models.responses.UserInfoResponse;
import funerary.genro.feliz.app.usecases.UserGateway;
import funerary.genro.feliz.domain.User;
import funerary.genro.feliz.auth.infra.security.TokenService;
import funerary.genro.feliz.auth.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository repository;
    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserGateway userGateway;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationResponse data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequest data){
        if(this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role(), data.firstName(), data.lastName(), data.cpf(), data.dataNascimento());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/user-info")
    public ResponseEntity<?> usersInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login;
        if (authentication.getPrincipal() instanceof UserDetails userDetails) {
            login = userDetails.getUsername();
        } else {
            login = authentication.getPrincipal().toString();
        }
      UserInfoResponse userInfo =  this.userGateway.userInfo(login);
      return ResponseEntity.ok(userInfo);
    }
}
