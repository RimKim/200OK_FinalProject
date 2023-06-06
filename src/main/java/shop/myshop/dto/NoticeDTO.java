package shop.myshop.dto;

import java.util.Date;

import org.apache.catalina.User;

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
public class NoticeDTO {
	
	private Integer noticeNo;
	private User userId;
	private String noticeTitle;
	private String noticeContent;
	private Date noticeRegdate;
	private Integer noticeCategory;
	private String noticeImage;

}
