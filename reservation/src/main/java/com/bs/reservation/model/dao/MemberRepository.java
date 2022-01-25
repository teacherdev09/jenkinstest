package com.bs.reservation.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bs.reservation.model.vo.Member;

public interface MemberRepository extends JpaRepository<Member, String>{

	public Member findByMemberId(String memberId);	
}
