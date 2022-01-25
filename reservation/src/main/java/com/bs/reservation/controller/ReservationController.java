package com.bs.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bs.reservation.model.service.ConferenceContentService;
import com.bs.reservation.model.service.ConferenceService;
import com.bs.reservation.model.service.MemberService;
import com.bs.reservation.model.service.ReservationService;
import com.bs.reservation.model.vo.Conference;
import com.bs.reservation.model.vo.ConferrenceContent;
import com.bs.reservation.model.vo.Member;
import com.bs.reservation.model.vo.Reservation;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/reservation")
@Slf4j
@CrossOrigin
public class ReservationController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private ConferenceService confService;
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private ConferenceContentService conferenceContentService;
	
	@GetMapping("/event/{confno}")
	public List<Reservation> getEvents(@PathVariable int confno){
		
		ConferrenceContent content=conferenceContentService.getConferrenceContent(confno);
		List<Reservation> result=reservationService.getEvents(content);
		return result;
	}
	@DeleteMapping("/event/{reservationNo}")
	public void deleteReservation(@PathVariable int reservationNo) {
		log.debug("{}",reservationNo);
		Reservation target=reservationService.findReserv(reservationNo);
		reservationService.deleteReservation(target); 
	}
	@PostMapping(value="/event",consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Reservation saveEvent(@RequestBody Reservation res) {
		log.debug("{}",res);
		Reservation result=reservationService.save(res);
		log.debug("{}",result);
		return result;
	}
	@PostMapping(value="/login",consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE )
	public Member getLogin(@RequestBody Member loginMember) {
		log.debug("{}",loginMember);
		Member temp=memberService.login(loginMember.getMemberId());
		if(!temp.getPassword().equals(loginMember.getPassword())) {
			temp=new Member();
		}
		log.debug("{}",temp);
		temp.setPassword(null);
		return temp;
	}
	
	@GetMapping(value="/conferences/{type}")
	public List<Conference> getConferenceData(@PathVariable String type){
		List<Conference> confList=null;
		switch(type) {
			case "all" : confList=confService.findAllConference();break;   
		}
		log.debug("{}",confList);
		return confList;
	}
	
	@PostMapping(value="/conference", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ConferrenceContent insertConference(@RequestBody ConferrenceContent content) {
		log.debug("{}",content);
		return conferenceContentService.insertConferrenceContent(content);
	}
	
	@PostMapping(value="/floor", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Conference insertConference(@RequestBody Conference conf) {
		
		log.debug("{}",conf);
		Conference result=confService.insertConf(conf);
		return result; 
	}
}











