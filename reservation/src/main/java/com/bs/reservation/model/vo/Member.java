package com.bs.reservation.model.vo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="MEMBER")
public class Member {
	@Id
	@Column(name="member_id")
	private String memberId;
	@Column(name="password")
	private String password;
	@Column(name="member_name" )
	private String memberName;
	@Column(name="class_name")
	private String className;
	@Column(name="memverLevel", columnDefinition = "number default 0")
	private int memberLevel;//0일반 사용자, 1관리자계정
}
