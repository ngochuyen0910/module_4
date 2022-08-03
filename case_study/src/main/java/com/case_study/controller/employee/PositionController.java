package com.case_study.controller.employee;

import com.case_study.model.employee.Position;
import com.case_study.service.position.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("position")
public class PositionController {
    @Autowired
    private IPositionService positionService;

    @GetMapping("")
    public String index(Model model) {
        List<Position> positionList = positionService.findAll();
        model.addAttribute("positionList", positionList);
        return "position/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("positionList", new Position());
        return "position/create";
    }

    @PostMapping("/save")
    public String save(Position position) {
        positionService.save(position);
        return "redirect:/position";
    }
}
