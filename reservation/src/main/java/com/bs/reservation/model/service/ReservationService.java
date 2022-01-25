package com.bs.reservation.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.reservation.model.dao.ReservationRepository;
import com.bs.reservation.model.vo.ConferrenceContent;
import com.bs.reservation.model.vo.Reservation;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationRepository respository;
	
	public Reservation save(Reservation res) {
		return respository.saveAndFlush(res);
	}
	
	public List<Reservation> getEvents(ConferrenceContent content){
		return respository.findAllByReservedConferece(content);
	}
	
	public Reservation findReserv(int no) {
		return respository.findByReservationno(no);
	}
	
	public void deleteReservation(Reservation res) {
		respository.delete(res);
	}
	
}
