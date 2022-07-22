package com.exercise.music.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicDto implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @Size(max = 800)
    @Pattern(regexp = "^[a-zA-Z\\s\\d\\p{L}]+$", message = "Not valid")
    private String nameMusic;
    @NotBlank
    @Size(max = 300)
    @Pattern(regexp = "^[a-zA-Z\\s\\d\\p{L}]+$", message = "Not valid")
    private String artist;
    @NotBlank
    @Size(max = 1000)
    @Pattern(regexp = "^[a-zA-Z,\\s\\d\\p{L}]+$", message = "Not valid")
    private String kindOfMusic;
    private String file;

    public MusicDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

