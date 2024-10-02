package ru.innopolis.java.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Сущность телевизора")
public class TelevisionDTO {
    @Schema(description = "Идентификатор", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Название телевизора")
    private String name;

    @Schema(description = "Стоимость телевизора")
    private int price;

    public TelevisionDTO() {}

    public TelevisionDTO(Long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
