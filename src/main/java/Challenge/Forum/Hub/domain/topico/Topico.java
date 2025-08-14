package Challenge.Forum.Hub.domain.topico;

import Challenge.Forum.Hub.domain.curso.Curso;
import Challenge.Forum.Hub.domain.resposta.Resposta;
import Challenge.Forum.Hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private StatusTopico status = StatusTopico.NAO_RESPONDIDO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Resposta> respostas = new ArrayList<>();

    public Topico(DadosCadastroTopico dados, Usuario autor, Curso curso){
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.autor = autor;
        this.curso = curso;
    }

    public void atualizarInformacoes(DadosAtualizacaoTopico dados){
        if(dados.titulo() != null){
            this.titulo = dados.titulo();
        }
        if(dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }
    }
}