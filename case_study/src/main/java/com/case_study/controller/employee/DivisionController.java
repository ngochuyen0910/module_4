package com.case_study.controller.employee;

import com.case_study.model.employee.Divisions;
import com.case_study.service.division.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("division")
public class DivisionController {
    @Autowired
    private IDivisionService divisionService;

    @GetMapping("")
    public String index(Model model) {
        List<Divisions> divisionList = divisionService.findAll();
        model.addAttribute("divisionList", divisionList);
        return "division/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("divisionList", new Divisions());
        return "division/create";
    }

    @PostMapping("/save")
    public String save(Divisions divisions) {
        divisionService.save(divisions);
        return "redirect:/division";
    }
}