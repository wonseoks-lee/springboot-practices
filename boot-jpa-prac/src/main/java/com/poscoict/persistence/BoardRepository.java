package com.poscoict.persistence;

import org.springframework.data.repository.CrudRepository;

import com.poscoict.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{
	
}
