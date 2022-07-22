package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ProductDto implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @Size(max = 100)
    @Pattern(regexp = "^[a-zA-Z\\s\\d\\p{L}]+$", message = "Not valid")
    private String name;
    private double price;
    @NotBlank
    @Size(max = 800)
    @Pattern(regexp = "^[a-zA-Z\\s\\d\\p{L}]+$", message = "Not valid")
    private String describe1;
    @NotBlank
    @Size(max = 100)
    @Pattern(regexp = "^[a-zA-Z\\s\\d\\p{L}]+$", message = "Not valid")
    private String producer;

    public ProductDto() {
    }

    public ProductDto(int id, String name, double price, String describe1, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.describe1 = describe1;
        this.producer = producer;
    }

    public String getDescribe1() {
        return describe1;
    }

    public void setDescribe1(String describe1) {
        this.describe1 = describe1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
