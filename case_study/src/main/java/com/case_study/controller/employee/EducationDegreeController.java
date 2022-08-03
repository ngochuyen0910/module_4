package com.case_study.controller.employee;

import com.case_study.model.employee.EducationDegree;
import com.case_study.service.education_degree.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("education_degree")
public class EducationDegreeController {
    @Autowired
    private IEducationDegreeService educationDegreeService;

    @GetMapping("")
    public String index(Model model) {
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
        model.addAttribute("educationDegreeList", educationDegreeList);
        return "education_degree/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("educationDegreeList", new EducationDegree());
        return "education_degree/create";
    }

    @PostMapping("/save")
    public String save(EducationDegree educationDegree) {
        educationDegreeService.save(educationDegree);
        return "redirect:/education_degree";
    }
}
