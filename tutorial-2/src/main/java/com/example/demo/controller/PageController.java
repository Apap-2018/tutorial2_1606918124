//Bahy Helmi Hartoyo Putra - 1606918124
//APAP - C
//Tutorial 2

package com.example.demo.controller;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	//File Tutorial
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}

	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name",name);
		return "challenge";
	}

	@RequestMapping(value = {"/challenge","/challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}
		else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}

	//Latihan Generator
	@RequestMapping("/generator")
	public String generator(@RequestParam(value = "a", defaultValue = "0") String aInput, @RequestParam(value = "b", defaultValue = "0") String bInput, Model model) {
		
		//Add Value To Model
		model.addAttribute("aValue", aInput);
		model.addAttribute("bValue", bInput);
		
		//Vars
		int a = Integer.parseInt(aInput);
		int b = Integer.parseInt(bInput);
		String hmText = "";
		
		//If B = 0, B+=1 So Can Loop
		if (b == 0) {
			b = 1;
		}
		
		//Word Loop
		for (int i = 0; i < b; i++) {
			if (i > 0 && i < b) {
				
				//Add Space After Hm
				hmText += " ";
			}
			hmText += "h";
			
			//If A = 0, Manually Add M
			if (a == 0) {
				hmText += "m";
			}
			
			//M Loop Above 0
			for (int j = 0; j < a; j++) {
				hmText += "m";
			}
		}
		
		//Add Hm To Model
		model.addAttribute("hmValue", hmText);
		return "generator";
	}
}
