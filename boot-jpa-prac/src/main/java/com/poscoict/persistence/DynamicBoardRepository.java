package com.poscoict.persistence;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.poscoict.domain.Board;

// <Entity, Id>
public interface DynamicBoardRepository extends CrudRepository<Board, Long>, QuerydslPredicateExecutor<Board>{
	
}
