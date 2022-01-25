package com.bs.reservation.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bs.reservation.model.vo.Conference;

public interface ConferenceRepository extends JpaRepository<Conference,Integer>{

	public List<Conference> findAll(); 
	
	
	@SuppressWarnings("unchecked")
	public Conference saveAndFlush(Conference conf);
}
