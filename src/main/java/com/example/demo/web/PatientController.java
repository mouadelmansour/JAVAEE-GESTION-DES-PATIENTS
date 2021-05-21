package com.example.demo.web;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.PatientRepositoty;
import com.example.demo.entities.Patient;

@Controller
public class PatientController {
	@Autowired
	private PatientRepositoty patientRepositoty;
	@GetMapping(value="/index")
	public String index() {
		return "index";
		
	}
	@GetMapping(value="/patients" )
	public String List(Model model, @RequestParam(name="page",defaultValue ="0")int page,
			@RequestParam(name="size",defaultValue ="3")int size,
			@RequestParam(name="KEYWORD",defaultValue ="")String kw) {
		Page<Patient> pagepatients =  patientRepositoty.findByNomContains(kw,PageRequest.of(page,size));
		model.addAttribute("patients",pagepatients.getContent());
		model.addAttribute("pages",new int[pagepatients.getTotalPages()]);
		model.addAttribute("currentpage",page);
		model.addAttribute("KEYWORD",kw);
		model.addAttribute("size",size);
		return "patients";
		
	}
	@GetMapping(value="/deletepatient")
	public String delete(Long id,String KEYWORD,int page, int size) {
		 patientRepositoty.deleteById(id);
		return "redirect:/patients?page="+page+"&size="+size+"&KEYWORD="+KEYWORD;
		
	}
	@GetMapping(value="/deletepatient2")
	public String delete2(Long id,String KEYWORD,int page, int size,Model model) {
		 patientRepositoty.deleteById(id);
		return List(model,page,size,KEYWORD);
		
	}
}
