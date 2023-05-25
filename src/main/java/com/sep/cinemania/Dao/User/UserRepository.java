package com.sep.cinemania.Dao.User;

import com.sep.cinemania.Entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,String> {
    @Query(nativeQuery = true,value = "select * from user_account where user_id != ?1")
    List<User> findOtherUsersById(String id);
    User findUserByEmail(@NotBlank(message = "email is mandatory") @Email String email);
}
