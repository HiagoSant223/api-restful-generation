package aluno.repository;

import aluno.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    //Query Method
    List<User>findByNomeContaining(String nome);

    //Query Method

    List<User> findByIdadeGreaterThan(Integer idade);

    List<User> findByNotaPrimeiroSemestreGreaterThan(Integer nota);

    List<User> findByNomeProfessor(String nomeProfessor);

    @Query("SELECT a FROM User a WHERE a.nome LIKE %:nome%")
    List<User> filtrarPorNome(@Param("nome") String nome);


}
