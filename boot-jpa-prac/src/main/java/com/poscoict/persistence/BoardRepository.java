package com.poscoict.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.poscoict.domain.Board;

// <Entity, Id>
public interface BoardRepository extends CrudRepository<Board, Long>{
	List<Board> findByTitle(String searchKeyword);
	List<Board> findByContentContaining(String searchKeyword);
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	
	// List<T> paging
	// List<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	
	// Page<T> paging
	Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	
	// 위치기반 파라미터 
	// ?1은 첫번째 파라미터를 의미
//	@Query("SELECT b from  Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
//	List<Board> queryAnnotationTest1(String searchKeyword);
	
	// 이름기반 파라미터
	@Query("SELECT b from Board b WHERE b.title like %:searchKeyword% ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest1(@Param("searchKeyword") String searchKeyword);
	
	// 특정 변수값들을 조회할때 object[]타입을 사용해야함
	@Query("SELECT b.seq, b.title, b.writer, b.createDate FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
	List<Object[]> queryAnnotationTest2(String searchKeyword);
	
	//persisstance를 뒤져본것이아닌 db를 뒤져본 
	@Query(value="select seq, title, writer, create_date from board where title like %?1% order by seq desc", nativeQuery=true)
	List<Object[]> queryAnnotationTest3(String searchKeyword);
	
}
