package com.springapp.mvc;

import com.springapp.business.HttpTest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.net.URISyntaxException;

@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) throws IOException, URISyntaxException {
		model.addAttribute("message", "Hello world!");
        model.addAttribute("test", "Prueba Danilo");
        model.addAttribute("uriTest", HttpTest.httpTest());
		return "hello";
	}
}