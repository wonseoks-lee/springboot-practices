package com.poscoict.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.poscoict.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{
	List<Board> findByTitle(String searchKeyword);
	List<Board> findByContentContaining(String searchKeyword);
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	
	// List<T> paging
	// List<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	
	// Page<T> paging
	Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	
}
