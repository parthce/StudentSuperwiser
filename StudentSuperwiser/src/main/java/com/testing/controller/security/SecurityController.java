package com.testing.controller.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.testing.model.profile.ProfileEntity;
import com.testing.service.security.UserDetailsServiceImpl;


@Controller
public class SecurityController {

	@Autowired
	private UserDetailsServiceImpl userDetailService;

	@RequestMapping(value = "/")
    public String defaultPage(ModelMap map) {
	
        return "redirect:/profile";
    }
	@RequestMapping(value = "/profile")
    public String profile(ModelMap map) {
		map.addAttribute("profile", new ProfileEntity());
    	return "profile";
    }
	
	/*@RequestMapping(value= "/login", method = RequestMethod.POST)
    public ModelAndView checkuser(@RequestParam("username")String username,@RequestParam("password")String password) {
		
		if(loginService.check(username, password)) { 
			System.out.println("Hello You Are Logged In SuccessFully");
			return new ModelAndView("profile");
			 }
		else{
			System.out.println("You Are Not Logged In Please Enter Valid Username OR Password");
			return new ModelAndView("login");
			}
    }*/
	
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String login(ModelMap model) {
	    	
	    	return "login";
	    }
	 
	    @RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	    public String loginerror(ModelMap model) {
	        model.addAttribute("error", "true");
	        return "denied";
	    }
	 
	    @RequestMapping(value = "/logout", method = RequestMethod.GET)
	    public String logout(ModelMap model) {
	        return "logout";
	    }
}
