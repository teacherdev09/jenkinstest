package com.bs.reservation.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.reservation.model.dao.ConferenceContentRepository;
import com.bs.reservation.model.dao.ConferenceRepository;
import com.bs.reservation.model.vo.ConferrenceContent;

@Service
public class ConferenceContentService {

	@Autowired
	private ConferenceContentRepository repository;
	
	public ConferrenceContent getConferrenceContent(int confno) {
		return repository.findByConfContentNo(confno);
	}
	
	public ConferrenceContent insertConferrenceContent(ConferrenceContent content) {
		return repository.saveAndFlush(content);
	}
	
}
