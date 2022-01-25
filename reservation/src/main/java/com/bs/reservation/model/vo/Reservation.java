package com.bs.reservation.model.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"confno","startDate"}))
@Entity(name = "RESERVATION")
@SequenceGenerator(name="seq_reservation_gen",
sequenceName = "SEQ_RESERVATION_NO",
initialValue = 1,allocationSize = 1)
public class Reservation implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1192581363698800029L;
	
	@Id
	@GeneratedValue(generator = "seq_reservation_gen",strategy=GenerationType.SEQUENCE)
	@Column(name="reservationno",columnDefinition = "NUMBER")
	private int reservationno;
	@Column(name="restitle", columnDefinition = "VARCHAR2(500)")
	private String title;
	@Column(name="startDate",columnDefinition = "TIMESTAMP")
	private Date start;
	@Column(name="endDate",columnDefinition = "TIMESTAMP")
	private Date end;
	@OneToOne
	@JoinColumn(name="confno")
	private ConferrenceContent reservedConferece;
	@OneToOne
	@JoinColumn(name="memberid")
	private Member revervedMember;
	
}
