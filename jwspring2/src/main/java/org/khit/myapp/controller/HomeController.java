package org.khit.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller  //@component ���
public class HomeController {
	
	//http://localhost:8080/
	@RequestMapping("/")
	public String home() { //���� �̸� ��ȯ(������)
		return "index";  //home.jsp
	}
	
}
