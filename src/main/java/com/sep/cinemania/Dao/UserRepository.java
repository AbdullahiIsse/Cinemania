package com.sep.cinemania.Dao;

import com.sep.cinemania.Entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
