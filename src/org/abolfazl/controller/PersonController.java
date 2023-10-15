package org.abolfazl.controller;

import org.abolfazl.entity.Person;
import org.abolfazl.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;


    @RequestMapping("/save")
    public String save(@ModelAttribute Person person){
        personService.save(person);
        return "redirect:/person/findAll";
    }

    @RequestMapping("update")
    public String update(@ModelAttribute Person person){
        personService.update(person);
        return "redirect:/person/findAll";
    }

    @RequestMapping("/remove")
    public String remove(@ModelAttribute Person person){
        personService.remove(person);
        return "redirect:/person/findAll";
    }

    @RequestMapping("/findAll")
    public String findAll(HttpServletRequest request){
        request.setAttribute("personList", personService.findAll());
        return "person/index";
    }
}
