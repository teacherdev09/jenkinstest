package com.bs.reservation.model.vo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="conference")
@SequenceGenerator(
		name="seq_confno_gen",sequenceName = "SEQ_CONFERNO",initialValue = 1,
		allocationSize = 1
		)
public class Conference {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_confno_gen")
	@Column(name="confno")
	private int confNo;
	@Column(name="floor", columnDefinition = "number unique")
	private String floor;
	
	@OneToMany
	@JoinColumn(name = "confno_ref")
	private List<ConferrenceContent> details;
	
}
