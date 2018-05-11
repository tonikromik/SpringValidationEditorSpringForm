package ua.com.owu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.owu.entity.User;

public interface UserDAO extends JpaRepository<User, Integer> {
    //JpaRepository це інтерфейс під капотом спрінга, в якову вже існує реалізація (автоматично отримуємо всі крад операції)


}
