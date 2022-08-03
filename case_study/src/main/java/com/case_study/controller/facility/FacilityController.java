package com.case_study.controller.facility;

import com.case_study.dto.FacilityDto;
import com.case_study.model.facility.Facility;
import com.case_study.service.facility.IFacilityService;
import com.case_study.service.facility_type.IFacilityTypeService;
import com.case_study.service.rent_type.IRentTypeService;
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
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IRentTypeService rentTypeService;

    @Autowired
    private IFacilityTypeService facilityTypeService;

    @GetMapping("/a")
    public String index(Model model) {
        List<Facility> facilityList = facilityService.findAll();
        model.addAttribute("facilityList", facilityList);
        return "facility/index";
    }

    @GetMapping("")
    public ModelAndView findAll(@PageableDefault(value = 3) Pageable pageable) {
        return new ModelAndView("facility/index", "facilityList", facilityService.findAll(pageable));
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("facility", new FacilityDto());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        return "facility/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated FacilityDto facilityDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "facility/create";
        } else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);

            facilityService.save(facility);
            redirectAttributes.addFlashAttribute("message", "Create OK!");
            model.addAttribute("facilityList", facilityService.findAll());
        }
        return "redirect:/facility";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("facility", facilityService.findById(id));
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        return "/facility/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Validated FacilityDto facilityDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("facilityTypeList", facilityTypeService.findAll());
            return "facility/edit";
        } else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);

            facilityService.update(facility.getFacilityId(), facility);
            redirectAttributes.addFlashAttribute("message", "Create OK!");
            model.addAttribute("facilityList", facilityService.findAll());
        }
        return "redirect:/facility";
    }
}