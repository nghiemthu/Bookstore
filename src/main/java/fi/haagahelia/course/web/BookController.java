package fi.haagahelia.course.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.course.domain.Book;

@Controller
public class BookController {

    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public String greetingForm(Model model) {
       
        return "hello";
    }

    @RequestMapping(value="/hello", method=RequestMethod.POST)
    public String greetingSubmit(@Valid Book msg, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
        	return "hello";
        }
        
    	model.addAttribute("message", msg);
        return "result";
    }

}