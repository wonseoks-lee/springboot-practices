package com.poscoict.service;

import java.util.List;


import com.poscoict.domain.BoardVO;

public interface BoardService {
	String hello(String name);
	
	BoardVO getBoard();
	
	List<BoardVO> getBoardList();
}
