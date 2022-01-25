package com.bs.reservation.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.reservation.model.dao.ConferenceRepository;
import com.bs.reservation.model.vo.Conference;

@Service
public class ConferenceService {
	@Autowired
	private ConferenceRepository confRepo;
	
	public List<Conference> findAllConference(){
		return confRepo.findAll();
	}
	
	public Conference insertConf(Conference conf) {
		return confRepo.saveAndFlush(conf);
	}
	
}
