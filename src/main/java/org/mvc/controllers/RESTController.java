package org.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import org.mvc.model.Person;
import org.mvc.service.PersonService;
import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@Controller
public class RESTController{
	
@Autowired
private PersonService personService;

@RequestMapping(value="/persons",method=RequestMethod.GET)
public String getAllPersons(Model model){

List<Person> persons=personService.getAll();
model.addAttribute("persons",persons);

return "persons";
}

@RequestMapping(value="persons/{id}",method=RequestMethod.GET)
public String getPerson(@PathVariable long id, Model model){
	
	model.addAttribute("person",personService.getById(id));
	
	return "edit";
}

@RequestMapping(value="persons/{id}",method=RequestMethod.PUT)
public String editPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult,@PathVariable long id){
	
if(bindingResult.hasErrors()) return "edit";
	
	person.setId(id);
	personService.edit(person);
	
return "redirect:/persons";
}

@RequestMapping(value="persons/{id}",method=RequestMethod.DELETE)
public String deletePerson(@PathVariable long id){
	
	personService.delete(id);
	
	return "redirect:/persons";
}

@RequestMapping(value="/persons",method=RequestMethod.POST)
public String addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult){
	
	if(bindingResult.hasErrors()) return "add";
	personService.add(person);

	return "redirect:/persons";
}

	
}