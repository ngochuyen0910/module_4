package com.exercise.music.controller;

import com.exercise.music.dto.MusicDto;
import com.exercise.music.model.Music;
import com.exercise.music.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping("")
    public String show(Model model) {
        List<Music> musicList = musicService.findAll();
        model.addAttribute("musicList", musicList);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("musicDto", new MusicDto());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated MusicDto musicDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model) {
        new MusicDto().validate(musicDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDto, music);

            musicService.save(music);
            redirectAttributes.addFlashAttribute("message", "Create OK!");
            model.addAttribute("musicList", musicService.findAll());
        }
        return "redirect:/music";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("music", musicService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Music music) {
        musicService.update(music.getId(), music);
        return "redirect:/music";
    }

    @GetMapping("/{id}/delete")
    private String delete(@PathVariable int id, Model model) {
        model.addAttribute("music", musicService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Music music, RedirectAttributes redirect) {
        musicService.remove(music.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/music";
    }
}
