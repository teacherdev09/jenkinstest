package com.bs.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomController {
	@RequestMapping("/")
	public String home() {
		return "index.html";
	}
}
