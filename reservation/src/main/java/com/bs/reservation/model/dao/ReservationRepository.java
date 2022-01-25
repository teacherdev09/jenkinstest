package com.bs.reservation.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bs.reservation.model.vo.ConferrenceContent;
import com.bs.reservation.model.vo.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
	 
	@SuppressWarnings("unchecked")
	public Reservation saveAndFlush(Reservation res);
	
	public List<Reservation> findAllByReservedConferece(ConferrenceContent content);
	
	public Reservation findByReservationno(int no);
	
	public void delete(Reservation res);
	
	
	
}
