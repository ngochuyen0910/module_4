package com.case_study.controller.employee;

import com.case_study.dto.EmployeeDto;
import com.case_study.model.employee.Employee;
import com.case_study.service.division.IDivisionService;
import com.case_study.service.education_degree.IEducationDegreeService;
import com.case_study.service.employee.IEmployeeService;
import com.case_study.service.position.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IDivisionService divisionService;

    @Autowired
    private IEducationDegreeService educationDegreeService;

    @Autowired
    private IPositionService positionService;

//    @GetMapping("/a")
//    public String index(Model model) {
//        List<Employee> employeeList = employeeService.findAll();
//        model.addAttribute("employeeList", employeeList);
//        return "employee/index";
//    }

    @GetMapping("")
    public ModelAndView findAll(@PageableDefault(value = 3) Pageable pageable) {
        return new ModelAndView("employee/index", "employeeList", employeeService.findAll(pageable));
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
        model.addAttribute("positionList", positionService.findAll());
        return "employee/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated EmployeeDto employeeDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "employee/create";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);

            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("message", "Create OK!");
            model.addAttribute("employeeList", employeeService.findAll());
        }
        return "redirect:/employee";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("employeeDto", employeeService.findById(id));
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
        model.addAttribute("positionList", positionService.findAll());
        return "employee/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Validated EmployeeDto employeeDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("divisionList", divisionService.findAll());
            model.addAttribute("educationDegreeList", educationDegreeService.findAll());
            model.addAttribute("positionList", positionService.findAll());
            return "employee/edit";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);

            employeeService.update(employee.getEmployeeId(), employee);
            redirectAttributes.addFlashAttribute("message", "Create OK!");
            model.addAttribute("employeeList", employeeService.findAll());
        }
        return "redirect:/employee";
    }

    @GetMapping("/{id}/delete")
    private String delete(@PathVariable int id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "/employee/delete";
    }

    @PostMapping("/delete")
    public String delete(int id) {
        employeeService.remove(id);
        return "redirect:/employee";
    }
}

