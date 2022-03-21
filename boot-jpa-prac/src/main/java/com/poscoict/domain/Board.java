package com.poscoict.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "member")
@Entity
public class Board{
	
	@Id @GeneratedValue
	private Long seq;
	
	private String title;
//	private String writer;
	private String content;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createDate;
	private Long cnt;
	
	@ManyToOne
	@JoinColumn(name="MEMBER_ID", nullable=false)
	private Member member;
	
	public void setMember(Member member) {
		System.out.println("member.getboardList1 : " + member.getBoardList());
		this.member = member;
		member.getBoardList().add(this);
		System.out.println("member.getboardList2 : " + member.getBoardList());
	}
}
