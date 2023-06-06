package shop.myshop.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import shop.myshop.entity.User;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CouponDTO {
	
	private Integer couponCode;	
	private String couponName;
	private Timestamp couponUsedate;
	private String couponBenefit;
	private String couponPrice;
	private String couponPayment;
	private Timestamp couponExpdate;
	private String couponUseYN;
	private User userId;
	
}
