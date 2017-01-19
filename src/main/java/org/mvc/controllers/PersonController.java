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

@Controller
public class PersonController{

@RequestMapping(value="/",method=RequestMethod.GET)
public String showHome(){

return "home";
}


@RequestMapping(value="/persons/add",method=RequestMethod.GET)
public String showAddPage(Model model){

	model.addAttribute("person",new Person());
	
return "add";
}


}
