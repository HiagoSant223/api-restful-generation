package aluno.service;

import aluno.model.User;

import java.util.List;

public interface UserService {
    User findById(Integer id);
    User create(User userToCreate);
    List<User> findAll(); // Método para obter todos os usuários
    User update(Integer id, User updatedUser); // Método para atualizar um usuário
    void delete(Integer id); // Método para excluir um usuário
}
