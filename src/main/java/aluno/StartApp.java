package aluno;

import aluno.model.User;
import aluno.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class StartApp implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        List<User> user = repository.findByNomeContaining("Hiago");
        for (User a : user) {
            System.out.println(a);
        }

        insereAlunosAleatorios();
    }
    private void insereAlunosAleatorios() {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i + 1);
            user.setNome(geraNomeAleatorio());
            user.setIdade(random.nextInt(10) + 18);
            user.setNotaPrimeiroSemestre(random.nextInt(11));
            user.setNotaSegundoSemestre(random.nextInt(11));
            user.setNomeProfessor(geraNomeAleatorio());
            user.setNumeroSala(random.nextInt(20) + 1);

            repository.save(user);
        }
    }

    private String geraNomeAleatorio() {
        String[] nomes = {"João", "Maria", "Pedro", "Ana", "Lucas", "Mariana", "Carlos", "Beatriz", "Rafael", "Laura"};
        String[] sobrenomes = {"Silva", "Oliveira", "Santos", "Pereira", "Ferreira", "Rodrigues", "Almeida", "Lima", "Gomes", "Costa"};

        Random random = new Random();
        String nomeAleatorio = nomes[random.nextInt(nomes.length)] + " " + sobrenomes[random.nextInt(sobrenomes.length)];
        return nomeAleatorio;
    }

}