package com.bs.reservation.model.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="conferencecontent")
@SequenceGenerator(name="seq_confcontent_gen",
					sequenceName = "SEQ_CONFCONTENT_NO",
					initialValue = 1,allocationSize = 1)
public class ConferrenceContent {
	@Id
	@GeneratedValue(generator = "seq_confcontent_gen",strategy=GenerationType.SEQUENCE)
	@Column(name="conf_contentno")
	private int confContentNo;
	@Column(name="limitcount")
	private int limitCount;
	@Column(name="conf_contentname",columnDefinition = "VARCHAR2(250)")
	private String confContentName;
	@Column(name="confno_ref")
	private int confNoRef;
//	@OneToOne
//	@JoinColumn(name="confno")
//	private Conference conf;
	
}
