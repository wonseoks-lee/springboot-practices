package com.poscoict.controller;

import java.util.List;

import com.poscoict.domain.BoardVO;
import com.poscoict.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
	
	@Autowired
	private BoardService boardService;
    
    public BoardController(){
        System.out.println("===> BaordController 생성");
    }

    @GetMapping("/hello")
    public String hello(String name){
        return "Hello : " + name;
    }
    
    @GetMapping("/getBoard")
    public BoardVO getBoard() {
        return boardService.getBoard();
    }

    @GetMapping("/getBoardList")
    public List<BoardVO> getBoardList() {
        return boardService.getBoardList();
    }
}
