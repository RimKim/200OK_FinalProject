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
public class AnswerDTO {
	private Integer answerNo;
	private String answerContent;
	private Timestamp answerRegdate;
	private String userId;
	private Integer questionNo;
}
