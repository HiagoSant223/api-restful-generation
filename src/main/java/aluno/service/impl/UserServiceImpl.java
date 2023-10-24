package aluno.service.impl;

import aluno.model.User;
import aluno.repository.UserRepository;
import aluno.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(User userToCreate) {
        Integer userId = userToCreate.getId();
        if (userId != null && userRepository.findById(userId).isPresent()) {
            throw new IllegalArgumentException("Usuário já existe!");
        }
        return userRepository.save(userToCreate);
    }

    @Override
    public User update(Integer id, User updatedUser) {
        User existingUser = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        existingUser.setId(updatedUser.getId());
        existingUser.setNome(updatedUser.getNome());
        existingUser.setIdade(updatedUser.getIdade());
        existingUser.setNotaPrimeiroSemestre(updatedUser.getNotaPrimeiroSemestre());
        existingUser.setNotaSegundoSemestre(updatedUser.getNotaSegundoSemestre());
        existingUser.setNomeProfessor(updatedUser.getNomeProfessor());
        existingUser.setNumeroSala(updatedUser.getNumeroSala());
        return userRepository.save(existingUser);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}



