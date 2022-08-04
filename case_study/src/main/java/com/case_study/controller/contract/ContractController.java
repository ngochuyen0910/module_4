package com.case_study.controller.contract;

import com.case_study.model.contract.Contract;
import com.case_study.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;

    @GetMapping("/a")
    public String index(Model model) {
        List<Contract> contractList = contractService.findAll();
        model.addAttribute("contractList", contractList);
        return "contract/index";
    }

    @GetMapping("")
    public ModelAndView findAll(@PageableDefault(value = 3) Pageable pageable) {
        return new ModelAndView("contract/index", "contractList", contractService.findAll(pageable));
    }
}
