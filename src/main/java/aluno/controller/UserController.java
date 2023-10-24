package aluno.controller;

import aluno.model.User;
import aluno.repository.UserRepository;
import aluno.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User userDetails) {
        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            user.setId(userDetails.getId());
            user.setNome(userDetails.getNome());
            user.setIdade(userDetails.getIdade());
            user.setNotaPrimeiroSemestre(userDetails.getNotaPrimeiroSemestre());
            user.setNotaSegundoSemestre(userDetails.getNotaSegundoSemestre());
            user.setNomeProfessor(userDetails.getNomeProfessor());
            user.setNumeroSala(userDetails.getNumeroSala());
            return userRepository.save(user);
        }

        return null;
    }

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }
}
