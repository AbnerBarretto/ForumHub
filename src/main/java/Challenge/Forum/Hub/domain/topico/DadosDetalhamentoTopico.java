package Challenge.Forum.Hub.domain.topico;

import Challenge.Forum.Hub.domain.resposta.DadosDetalhamentoResposta;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record DadosDetalhamentoTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        StatusTopico status,
        String nomeAutor,
        List<DadosDetalhamentoResposta> respostas
) {

    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                topico.getAutor().getNome(),
                topico.getRespostas().stream()
                        .map(DadosDetalhamentoResposta::new)
                        .collect(Collectors.toList()));
    }
}