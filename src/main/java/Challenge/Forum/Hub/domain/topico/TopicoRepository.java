package Challenge.Forum.Hub.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    @Query("""
            SELECT t FROM Topico t
            JOIN FETCH t.autor
            LEFT JOIN FETCH t.respostas
            WHERE t.id = :id
            """)
    Optional<Topico> findByIdWithDetails(Long id);

}
