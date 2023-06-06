package shop.myshop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import shop.myshop.dto.Role;
@DynamicInsert   //(insert 시 null 인필드 제외)
@DynamicUpdate //(update 시 null 인필드 제외)
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class User {
	

	@Id
	private String userId;
	
	@NonNull
	@Column(nullable = false)
	private String userName;
	
	@NonNull
	@Column(nullable = false)
	private String userPwd;
	
	@NonNull
	@Column(nullable = false)
	private String userMobile;
	
	@Column(nullable = true)
	private String userPhone;
	
	@NonNull
	@Column(nullable = false)
	private String userAddr1;
	
	@NonNull
	@Column(nullable = false)
	private String userAddr2;
	
	@Column(nullable = true)
	private String userAddr3;
	
	@Column(nullable = true )
	private String userEmailwhether;
	

	@Column(nullable = true)
	private String userSnswhether;
	
	@NonNull
	@Column(nullable = false)
	private String userEmail;
	
    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private Role userRole;
	
	@NonNull
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")
	@Column(nullable = false )
	private  Date userRegdate;
	
	@NonNull
	@Column(nullable = true)
	private String userProvider;
	
	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
	private List<Cart> Cart = new ArrayList<Cart>();
	
	

	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
	private List<Orders> orders = new ArrayList<Orders>();
	
	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
	private List<Question> question = new ArrayList<Question>();
	
	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
	private List<ProductQuestion> productquestion = new ArrayList<ProductQuestion>();
	
	
	
	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
	private List<Review> review = new ArrayList<Review>();
	
	
	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
	private List<Notice> notice= new ArrayList<Notice>();
	
	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
	private List<ProductAnswer> productanswer= new ArrayList<ProductAnswer>();

	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
	private List<Delivery> delivery = new ArrayList<Delivery>();
	

	@Override
	public String toString() {
	return "User{" +
	"userId='" + userId + ' ' +
	", userName='" + userName + ' ' +
	", userPwd='" + userPwd + ' ' +
	", userMobile='" + userMobile + ' ' +
	", userPhone='" + userPhone + ' ' +
	", userAddr1='" + userAddr1 + ' ' +
	", userAddr2='" + userAddr2 + ' ' +
	", userAddr3='" + userAddr3 + ' ' +
	", userEmailwhether='" + userEmailwhether + ' ' +
	", userSnswhether='" + userSnswhether + ' ' +
	", userEmail='" + userEmail + ' ' +
	", userRole=" + userRole +
	", userRegdate=" + userRegdate +
	", userProvider='" + userProvider + ' ' +
	'}';
	}
	
}
