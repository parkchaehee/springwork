package org.khit.myapp.controller;

import org.khit.myapp.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.filter.CharacterEncodingFilter;

@RequestMapping("/user")
@Controller
public class SampleController {

	//http://localhost:8080/user/join
	//@RequestMapping("/join")
	@GetMapping("/join")
	public String joinForm() {  //���� ��
		return "user/join";  // user/join.jsp
	}
	
	@PostMapping("/join")
	public String joinPost(UserDTO userDTO) {
		System.out.println("userDTO=" + userDTO);
		return "redirect:/";  //index�� ���� �̵�
	}
	
	// ���� ó��
	@GetMapping("/join2")
	public String join(UserDTO userDTO) {
		//�������� �Ķ����(�Լ��� �Ű�����)�� name �Ӽ��� ����(request ������)
		System.out.println(userDTO);
		return "index";
	}
	
	@GetMapping("/join3")
	public String join(@RequestParam("name") String name) {
		//�������� �Ķ����(�Լ��� �Ű�����)�� name �Ӽ��� ����(request ������)
		System.out.println("�̸�: " + name);
		return "index";
	}
}
