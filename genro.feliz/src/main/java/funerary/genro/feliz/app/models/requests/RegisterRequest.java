package funerary.genro.feliz.app.models.requests;

import funerary.genro.feliz.domain.UserRole;

public record RegisterRequest(String login, String password, UserRole role) {
}
