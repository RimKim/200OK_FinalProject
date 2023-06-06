package shop.myshop.dto;

import java.sql.Timestamp;

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
public class ProductAnswerDTO {
	
	private Integer productanswerNo;
	private String productanswerContent;
	private Timestamp productanswerRegdate;
	private String userId;
	private Integer productCode;

}
