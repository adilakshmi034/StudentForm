package com.studentform.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentform.Entity.Student;
import com.studentform.Repository.StudentRepository;

@org.springframework.stereotype.Controller
public class Controller {
	
	 @Autowired
	    private StudentRepository studentRepository;

	    @GetMapping("/login")
	    public String showLoginForm() {
	        return "login";
	    }

	    @PostMapping("/login")
	    public String login(@RequestParam String username, @RequestParam String password, Model model) {
	        Student student = studentRepository.findByUsername(username);
	        if (student != null && student.getPassword().equals(password)){
	            // Redirect to student details page
	            model.addAttribute("student", student);
	            return "student-details";
	        } else {
	            // Redirect to registration page with a message
	            model.addAttribute("message", "Username and password already exist. Please register with a different username/password.");
	            return "redirect:/register";
	        }
	    }


	    @GetMapping("/register")
	    public String showRegistrationForm(Model model) {
	        model.addAttribute("student", new Student());
	        return "register";
	    }

	    @PostMapping("/register")
	    public String register(@ModelAttribute Student student) {
	        studentRepository.save(student);
	        return "redirect:/login";
	    }
	
	

}
