package com.ControlUsuarios.persitence.repository;

import com.ControlUsuarios.persitence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<UserEntity, String> {
}
