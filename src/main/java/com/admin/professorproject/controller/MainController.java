package com.admin.professorproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping("/")
	@ResponseBody
	public String index() {
		String response = "Bienvenido Curso Profesional de JavaEE de <a href='http://platzi.com'>platzi.com</a> :D";
		return response;
	}
}
