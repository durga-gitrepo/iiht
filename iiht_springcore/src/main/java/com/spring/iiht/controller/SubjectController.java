package com.spring.iiht.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.iiht.model.Subject;
import com.spring.iiht.service.ApplicationService;

@Controller
public class SubjectController {

	@Autowired
	ApplicationService appService;

	@RequestMapping(path = "/subject/list", method = RequestMethod.GET)
	public String getAllSubjects(Model model) throws Exception {
		List<Subject> subjectList = appService.getAllSubjects();
		model.addAttribute("subjects", subjectList);
		return "subjects";
	}
	
	@RequestMapping(path = {"/subject/search"}, method = RequestMethod.POST)
	public String getSubject(@RequestParam(name="duration", value ="duration", required=false) Integer duration, Model model) throws Exception {
		List<Subject> subjectList = new ArrayList<Subject>();
		System.out.println("duration ---"+duration);
		
		if(duration != null && duration >0)
		{
			subjectList = appService.getSubject(duration);
		}
		else
		{
			subjectList = appService.getAllSubjects();
		}
		model.addAttribute("subjects", subjectList);
		return "subjects";
	}
	
	@RequestMapping(path = "/subject/add-subject-form", method = RequestMethod.GET)
	public String showSubjectForm(Model model) throws Exception {
		Subject subject = new Subject();
		model.addAttribute("subject", subject);
		return "add-subject-form";
	}
	
	@RequestMapping(path = "/subject/create", method = RequestMethod.POST)
	public String addSubject(@ModelAttribute("subject") Subject newSubject) throws Exception {
		appService.addSubject(newSubject);
		return "redirect:/subject/list";
	}
	
	@RequestMapping(path = "/subject/delete", method = RequestMethod.GET)
	public String deleteSubject(@RequestParam Long subjectId) throws Exception {
		appService.deleteSubject(subjectId);
		return "redirect:/subject/list";
	}
}
