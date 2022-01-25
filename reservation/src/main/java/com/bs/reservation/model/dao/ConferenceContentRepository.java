package com.bs.reservation.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bs.reservation.model.vo.ConferrenceContent;

public interface ConferenceContentRepository extends JpaRepository<ConferrenceContent, Integer>{
	public ConferrenceContent findByConfContentNo(int no);
	
	@SuppressWarnings("unchecked")
	public ConferrenceContent saveAndFlush(ConferrenceContent content);
}
