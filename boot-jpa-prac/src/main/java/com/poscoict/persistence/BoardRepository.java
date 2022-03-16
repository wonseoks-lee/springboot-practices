package com.poscoict.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.poscoict.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{
	List<Board> findByTitle(String searchKeyword);
	List<Board> findByContentContaining(String searchKeyword);
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	
	
}
