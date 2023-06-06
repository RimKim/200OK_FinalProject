package shop.myshop.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
	
	private String userId;	
	private String userName;
	private String userPwd;
	private String userMobile;
	private String userPhone;
	private String userAddr1;
	private String userAddr2;
	private String userAddr3;
	private String userEmailwhether;
	private String userSnswhether;
	private String userEmail;
	private Role userRole;
	private Date userRegdate;
	private String userProvider;
	
	public UserDTO(String userId, String userPwd) {
		this.userId = userId;
		this.userPwd = userPwd;
	}

	public UserDTO(String userId,String userName, String userPwd, String userMobile, String userPhone, String userAddr1, String userAddr2, String userAddr3,String userEmailwhether, String userSnswhether,   String userEmail, Date userRegdate) {
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userMobile = userMobile;
		this.userPhone = userPhone;
		this.userAddr1 = userAddr1;
		this.userAddr2 = userAddr2;
		this.userAddr3 = userAddr3;
		this.userEmailwhether = userEmailwhether;
		this.userSnswhether = userSnswhether;
		this.userEmail = userEmail;
		this.userRegdate = userRegdate;
	}
	
	
	
	
}
