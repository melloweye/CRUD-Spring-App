package ru.innopolis.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.java.entity.Television;

public interface TelevisionRepository extends JpaRepository<Television, Long> {
}
