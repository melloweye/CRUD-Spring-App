package ru.innopolis.java.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.java.dto.TelevisionDTO;
import ru.innopolis.java.entity.Television;
import ru.innopolis.java.service.TelevisionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/televisions")
@Tag(name = "Основной Контроллер", description = "Позволяет работать с CRUD-методами базы данных телевизоров")
public class TelevisionController {

    private final TelevisionService televisionService;

    // DI в конструктор
    @Autowired
    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    // CREATE
    @Operation(
            summary = "Создание нового телевизора",
            description = "Позволяет создать новый телевизор"
    )
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
    @Operation(
            summary = "Получение телевизора по id",
            description = "Позволяет получить телевизор по заданному id"
    )
    @GetMapping("/{id}")
    public ResponseEntity<TelevisionDTO> getTelevisionById(@PathVariable Long id) {
        Television television = televisionService.getTelevisionById(id);
        TelevisionDTO televisionDTO = new TelevisionDTO(television.getId(), television.getTelevisionBrand(), television.getTelevisionPrice());
        return ResponseEntity.ok(televisionDTO);
    }

    // READ
    @Operation(
            summary = "Получение списка телевизоров",
            description = "Позволяет получить список всех телевизоров"
    )
    @GetMapping
    public List<TelevisionDTO> getAllTelevisions(){
        return televisionService.getAllTelevisions().stream()
                .map(television -> new TelevisionDTO(television.getId(), television.getTelevisionBrand(), television.getTelevisionPrice()))
                .collect(Collectors.toList());
    }

    // UPDATE
    @Operation(
            summary = "Добавление нового телевизора по id",
            description = "Позволяет добавить новый телевизор по заданному id"
    )
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
    @Operation(
            summary = "Удаление телевизора по id",
            description = "Позволяет удалить телевизор по заданному id"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable Long id) {
        televisionService.deleteTelevision(id);
        return ResponseEntity.noContent().build();
    }
}
