package com.khit.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter*/
@Data
public class UserDTO {
	//�ʵ�
	private Long id;
	private String userId;
	private String userPasswd;
	private String userName;
	private String userAge;
}
