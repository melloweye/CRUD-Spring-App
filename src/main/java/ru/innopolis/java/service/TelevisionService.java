package ru.innopolis.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.java.entity.Television;
import ru.innopolis.java.repository.TelevisionRepository;

import java.util.List;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    // DI в конструктор
    @Autowired
    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public List<Television> getAllTelevisions() {
        return televisionRepository.findAll();
    }

    public Television getTelevisionById(Long id) {
        return televisionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Television not found"));
    }

    public Television createTelevision(Television television) {
        return televisionRepository.save(television);
    }

    public Television updateTelevision(Television television) {
        return televisionRepository.save(television);
    }

    public void deleteTelevision(Long id) {
        televisionRepository.deleteById(id);
    }
}
