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
public class ProductQuestionDTO {
	private Integer productquestionNo;
	private String productquestionTitle;
	private String productquestionContent;
	private Timestamp productquestionRegdate;
	private Integer productquestionPublication;
	private String userId;
	private Integer productCode;

}
