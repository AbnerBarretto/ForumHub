package Challenge.Forum.Hub.domain.autenticacao;

import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacao(
        @NotBlank
        String login, // O campo agora é 'login'

        @NotBlank
        String senha
){
}