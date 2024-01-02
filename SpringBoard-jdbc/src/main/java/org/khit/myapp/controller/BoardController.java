package org.khit.myapp.controller;

import java.util.List;

import org.khit.myapp.dto.BoardDTO;
import org.khit.myapp.repository.BoardRepository;
import org.khit.myapp.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor  ////������ ���� new - �Ű������� �ִ� ������
@Slf4j
@RequestMapping("/board")
@Controller //bean ��ü�� ���
public class BoardController {
	
	//@Autowired
	private BoardService boardService;

	//�۾��� �� ������
	@GetMapping("/write")
	public String writeForm() {
		return "/board/write";  // /board/write.jsp
	}
	
	//�۾��� ó��
	@PostMapping("/write")
	public String write(@ModelAttribute BoardDTO boardDTO) {
		//@RequestParam("boardTitle") String boardTitle
		log.info("boardDTO=" + boardDTO);
		boardService.save(boardDTO);
		return "redirect:/board/list";  //response.sendRedirect()
	}
	
	//�� ���
	@GetMapping("/list")
	public String getListAll(Model model) {
		List<BoardDTO> boardDTOList = boardService.getListAll();
		model.addAttribute("boardList", boardDTOList);
		//request.setAttribute()
		return "/board/list";
	}
	
	//�� �󼼺���
	//board?id=1
	@GetMapping
	public String getBoard(@RequestParam("id") Long id,
			Model model) {
		BoardDTO boardDTO = boardService.findById(id);
		model.addAttribute("board", boardDTO);
		return "/board/detail";
	}
	
	//�� ���� ó��
	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		boardService.delete(id);
		return "redirect:/board/list";
	}
	
	//�� ���� ������
	@GetMapping("/update")
	public String update(@RequestParam("id") Long id,
			Model model) {
		//������ �ش� �� ��������
		BoardDTO boardDTO = boardService.findById(id);
		model.addAttribute("board", boardDTO);
		return "/board/update";  //update.jsp
	}
	
	//�� ���� ó��
	@PostMapping("/update")
	public String update(@ModelAttribute BoardDTO boardDTO) {
		boardService.update(boardDTO);
		return "redirect:/board/list";
	}
	
}
