package com.bs.reservation.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.reservation.model.dao.MemberRepository;
import com.bs.reservation.model.vo.Member;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	public Member login(String memberId){
		return memberRepository.findByMemberId(memberId);
	}

}
