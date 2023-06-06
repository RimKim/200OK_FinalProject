package shop.myshop.dto;

import java.sql.Timestamp;
import java.util.Date;

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
public class MileageDTO {
	
	private Integer mileageCode;	
	private Timestamp mileageRegdate;
	private String mileageContent;
	private Integer mileagePrice;
	private User userId;
	
}
