package com.krista.crudassignment.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.krista.crudassignment.models.Language;
import com.krista.crudassignment.services.LanguageService;

@Controller

public class Languages {
	
	  private final LanguageService languageService;
	    public Languages(LanguageService languageService){
	        this.languageService = languageService;
	    }
	    
	    @RequestMapping("/")
	    public String languages(@ModelAttribute("language") Language language, Model model) {
	        List<Language> languages = languageService.allLanguages();
	        model.addAttribute("languages",languages);
	        model.addAttribute("language", new Language());
	        return "languages";
	    }

	    
	    @RequestMapping("/show/{index}")
	    public String findLanguageByIndex(@PathVariable("index") int index, Model model, HttpSession session) {
	        session.setAttribute("id", index );
	    		Language language = languageService.findLanguageByIndex(index);
	        model.addAttribute("language", language);
	        return "showLanguage";
	    }
	    
	    
	    @RequestMapping("/new")
	    public String newLanguage(@ModelAttribute("language") Language language) {
	        return "newLanguage";
	    }
	    
	    @PostMapping("/new")
	    public String createLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
	        if (result.hasErrors()) {
	            return "newLanguage";
	        }else{
	            languageService.addLanguage(language);
	            return "redirect:/";
	        }
	    }
	    
	    @RequestMapping("/edit/{id}")
	    public String editLanguage(@PathVariable("id") int id, Model model, HttpSession session) {
	    	
	    		System.out.println(session);
	        Language language = languageService.findLanguageByIndex(id);
	        if (language != null){
	            model.addAttribute("language", language);
	            return "editLanguage";
	        }else{
	            return "redirect:/";
	        }
	    }
	    
	    @PostMapping("/edit/{id}")
	    public String updateLanguage(@PathVariable("id") int id, @Valid @ModelAttribute("language") Language language, BindingResult result) {
	        if (result.hasErrors()) {
	            return "editLanguage";
	        }else{
	            languageService.updateLanguage(id, language);
	            return "redirect:/";
	        }
	    }
	    
	    @RequestMapping(value="/delete/{id}")
	    public String destroyLanguage(@PathVariable("id") int id, HttpSession session) {
	        languageService.destroyLanguage(id);
	        return "redirect:/";
	    }
}