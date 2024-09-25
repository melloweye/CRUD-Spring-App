package ru.innopolis.java.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "television")
public class Television {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String TelevisionBrand;

    private int TelevisionPrice;

    private String TelevisionOwner;

    public Television() {}

    public Television(String televisionBrand, int televisionPrice, String televisionOwner) {
        this.TelevisionBrand = televisionBrand;
        this.TelevisionPrice = televisionPrice;
        this.TelevisionOwner = televisionOwner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelevisionBrand() {
        return TelevisionBrand;
    }

    public void setTelevisionBrand(String televisionBrand) {
        TelevisionBrand = televisionBrand;
    }

    public int getTelevisionPrice() {
        return TelevisionPrice;
    }

    public void setTelevisionPrice(int televisionPrice) {
        TelevisionPrice = televisionPrice;
    }

    public String getTelevisionOwner() {
        return TelevisionOwner;
    }

    public void setTelevisionOwner(String televisionOwner) {
        TelevisionOwner = televisionOwner;
    }
}
