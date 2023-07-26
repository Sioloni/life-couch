package ru.project.life.couch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.project.life.couch.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
