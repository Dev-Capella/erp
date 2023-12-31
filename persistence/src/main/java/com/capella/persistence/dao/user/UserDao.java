package com.capella.persistence.dao.user;
import com.capella.domain.model.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserModel, Long> {
    UserModel getByUsername(String username);
}
