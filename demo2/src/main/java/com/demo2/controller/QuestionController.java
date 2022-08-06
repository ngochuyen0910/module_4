package com.demo2.controller;

import com.demo2.dto.QuestionDto;
import com.demo2.model.Question;
import com.demo2.repository.IQuestionTypeRepository;
import com.demo2.service.IQuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private IQuestionService questionService;

    @Autowired
    private IQuestionTypeRepository questionTypeRepository;

    @GetMapping
    public String index(Model model) {
        List<Question> questionList = questionService.findAll();
        model.addAttribute("questionList", questionList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("questionDto", new QuestionDto());
        model.addAttribute("questionTypeList", questionTypeRepository.findAll());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated QuestionDto questionDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model) {
        new QuestionDto().validate(questionDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            Question question = new Question();
            BeanUtils.copyProperties(questionDto, question);

            questionService.save(question);
            redirectAttributes.addFlashAttribute("message", "Create OK!");
            model.addAttribute("questionList", questionService.findAll());
        }
        return "redirect:/question";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("questionDto", questionService.findById(id));
        model.addAttribute("questionTypeList", questionTypeRepository.findAll());
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Validated QuestionDto questionDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        new QuestionDto().validate(questionDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("questionTypeList", questionTypeRepository.findAll());
            return "edit";
        } else {
            Question question = new Question();
            BeanUtils.copyProperties(questionDto, question);

            questionService.update(question.getQuestionId(), question);
            redirectAttributes.addFlashAttribute("message", "Create OK!");
            model.addAttribute("questionList", questionService.findAll());
        }
        return "redirect:/question";
    }

    @GetMapping("/{id}/delete")
    private String delete(@PathVariable int id, Model model) {
        model.addAttribute("question", questionService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Question question) {
        questionService.remove(question.getQuestionId());
        return "redirect:/question";
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam("search") String search,
                               @RequestParam("searchss") String searchss) {
        List<Question> questions = questionService.findByNameContaining(search, searchss);
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("questionList", questions);
        return modelAndView;
    }
}
