package com.WLApp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import com.WLApp.model.Greeting;
import com.WLApp.model.TagDescription;
import com.WLApp.service.GetTagPageService;

@Controller
public class DefaultController {

	@Autowired
	GetTagPageService getPageService;
		
	
	
	@GetMapping("/")
	public String home1(Model model) {
		
		return "/home";
	}

	@GetMapping("/home")
	public String home() {
		return "/home";
	}

	@GetMapping("/admin")
	public String admin() {
		return "/admin";
	}

	/*@GetMapping("/user")
	public String user() {
		return "/user";
	}

	*/

	@GetMapping("/about")
	public String about() {
		return "/about";
	}

	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	/*private final OAuth2RestTemplate restTemplate;
	@GetMapping("/user")
     ResponseEntity<?> myself(WebRequest request) {
        System.out.println("request:" + request);
        // System.out.println(restTemplate.getForObject("/myself", Map.class));
        final Map<?, ?> result = restTemplate.getForObject("/myself", Map.class);
        System.out.println("result:" + result);
        return ResponseEntity.ok(result);
    }*/
	/*public String getPage() {
		return "/getPage";
	}
*/
	@GetMapping("/403")
	public String error403() {
		return "/error/403";
	}

	  @GetMapping("/greeting")
	  public String greetingForm(Model model) {
	    model.addAttribute("greeting", new Greeting());
	    return "greeting";
	  }

	  @PostMapping("/greeting")
	  public String greetingSubmit(@ModelAttribute Greeting greeting) {
		  System.out.println(greeting.getContent());
	    return "greeting";
	  }
	  @GetMapping("/tagDescription")
	  public String tagForm(Model model) {
	    model.addAttribute("tagDescription", new TagDescription());
	 
	    return "tagDescription";
	  }

	  @PostMapping("/tagDescription")
	  public String greetingSubmit(@ModelAttribute TagDescription tagDescription) {
		  tagDescription.setTagName(getPageService.getPages(tagDescription.getTagName()));
		  System.out.println(tagDescription.getTagName());
	    return "result";
	  }
	  


}
