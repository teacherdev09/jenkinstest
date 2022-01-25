package com.bs.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomController {
	@RequestMapping("/")
	public String home() {
		return "index.html";
	}
}
