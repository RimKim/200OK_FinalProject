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
public class QuestionDTO {
	
	private Integer qusetionNo;
	private String qusetionTitle;
	private String qusetionContent;
	private Timestamp qusetionRegdate;
	private String qusetionCategory;
	private Integer qusetionPublication;
	private String userId;

}
