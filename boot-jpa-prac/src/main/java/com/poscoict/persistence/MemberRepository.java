package com.poscoict.persistence;

import org.springframework.data.repository.CrudRepository;

import com.poscoict.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String>{
	
}
