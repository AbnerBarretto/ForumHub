package Challenge.Forum.Hub.domain.resposta;

import Challenge.Forum.Hub.domain.topico.Topico;
import Challenge.Forum.Hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "Resposta")
@Table(name = "respostas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String mensagem;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    private boolean solucao = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id", nullable = false)
    private Topico topico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;

}