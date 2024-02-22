package funerary.genro.feliz.auth.service;

import funerary.genro.feliz.auth.dto.UserDTO;
import funerary.genro.feliz.auth.model.User;
import funerary.genro.feliz.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<UserDTO> login(UserDTO userDTO) {
        User user = this.userRepository.findByEmail(userDTO.email());
        if(user == null){
            throw new RuntimeException("Login não existe");
        } else {
            return ResponseEntity.ok().build();
        }

    }
}
