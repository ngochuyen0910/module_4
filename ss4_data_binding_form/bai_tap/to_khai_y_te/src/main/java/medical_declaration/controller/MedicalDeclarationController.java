package medical_declaration.controller;

import medical_declaration.model.MedicalDeclaration;
import medical_declaration.service.IMedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MedicalDeclarationController {
    @Autowired
    private IMedicalDeclarationService medicalDeclarationService;

    @GetMapping("")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index", "medicalDeclaration", new MedicalDeclaration());
        String[] dayOfBirth = medicalDeclarationService.getDayOfBirth();
        modelAndView.addObject("dayOfBirth", dayOfBirth);

        String[] gender = medicalDeclarationService.getGender();
        modelAndView.addObject("gender", gender);

        String[] nationality = medicalDeclarationService.getNationality();
        modelAndView.addObject("nationality", nationality);

        String[] travel = medicalDeclarationService.getTravelInformation();
        modelAndView.addObject("travel", travel);

        String[] day = medicalDeclarationService.getDepartureDay();
        modelAndView.addObject("day", day);

        String[] month = medicalDeclarationService.getDepartureMonth();
        modelAndView.addObject("month", month);

        String[] year = medicalDeclarationService.getDepartureYear();
        modelAndView.addObject("year", year);

        String[] days = medicalDeclarationService.getEndDay();
        modelAndView.addObject("days", days);

        String[] months = medicalDeclarationService.getEndMonth();
        modelAndView.addObject("months", months);

        String[] years = medicalDeclarationService.getEndYear();
        modelAndView.addObject("years", years);

        String[] province = medicalDeclarationService.getProvince();
        modelAndView.addObject("province", province);

        String[] district = medicalDeclarationService.getDistrict();
        modelAndView.addObject("district", district);

        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("medicalDeclaration") MedicalDeclaration medicalDeclaration) {
        ModelAndView modelAndView = new ModelAndView("result");
        return modelAndView;
    }
}
