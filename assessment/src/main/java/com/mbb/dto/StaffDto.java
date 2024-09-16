package com.mbb.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StaffDto {

	private int id;
	private String name;
	private String department;
	private String jobGrade;
}
