package ru.innopolis.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.java.dto.TelevisionDTO;
import ru.innopolis.java.entity.Television;
import ru.innopolis.java.service.TelevisionService;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService televisionService;

    // DI в конструктор
    @Autowired
    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<TelevisionDTO> createTelevision(@RequestBody TelevisionDTO televisionDTO) {
        Television television = new Television();
        television.setTelevisionBrand(televisionDTO.getName());
        television.setTelevisionPrice(televisionDTO.getPrice());
        Television createdTelevision = televisionService.createTelevision(television);
        TelevisionDTO createdTelevisionDTO = new TelevisionDTO(createdTelevision.getId(), createdTelevision.getTelevisionBrand(), createdTelevision.getTelevisionPrice());
        return ResponseEntity.status(201).body(createdTelevisionDTO);
    }

    // READ
    @GetMapping("/{id}")
    public ResponseEntity<TelevisionDTO> getTelevisionById(@PathVariable Long id) {
        Television television = televisionService.getTelevisionById(id);
        TelevisionDTO televisionDTO = new TelevisionDTO(television.getId(), television.getTelevisionBrand(), television.getTelevisionPrice());
        return ResponseEntity.ok(televisionDTO);
    }

    // READ
    @GetMapping
    public List<TelevisionDTO> getAllTelevisions(){
        return televisionService.getAllTelevisions().stream()
                .map(television -> new TelevisionDTO(television.getId(), television.getTelevisionBrand(), television.getTelevisionPrice()))
                .collect(Collectors.toList());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<TelevisionDTO> updateTelevision (@PathVariable Long id, @RequestBody TelevisionDTO televisionDTO) {
        Television television = televisionService.getTelevisionById(id);
        television.setTelevisionBrand(televisionDTO.getName());
        television.setTelevisionPrice(televisionDTO.getPrice());
        Television updatedTelevision = televisionService.updateTelevision(television);
        TelevisionDTO updatedTelevisionDTO = new TelevisionDTO(updatedTelevision.getId(), updatedTelevision.getTelevisionBrand(), updatedTelevision.getTelevisionPrice());
        return ResponseEntity.ok(updatedTelevisionDTO);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable Long id) {
        televisionService.deleteTelevision(id);
        return ResponseEntity.noContent().build();
    }
}
