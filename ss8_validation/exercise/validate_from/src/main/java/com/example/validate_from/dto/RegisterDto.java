package com.example.validate_from.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterDto implements Validator {
    private int id;
    @NotBlank(message = "Khong duoc de trong")
    @Size(min = 5, max = 45, message = "Ten it nhat 5 ki tu và nhieu nhat 45 ki tu")
    private String firstName;
    @NotBlank(message = "Khong duoc de trong")
    @Size(min = 5, max = 45, message = "Ten it nhat 5 ki tu và nhieu nhat 45 ki tu")
    private String lastName;
    @NotBlank(message = "Khong duoc de trong")
    @Pattern(regexp = "^0\\d{9}$", message = "SĐT phai 10 so")
    private String phoneNumber;
    @NotBlank(message = "Khong duoc de trong")
    private String email;

    public RegisterDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegisterDto registerDto = (RegisterDto) target;
    }
}

