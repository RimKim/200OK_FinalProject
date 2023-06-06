package shop.myshop.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Notice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer noticeNo;
	
	@ManyToOne
	@NonNull
	@JoinColumn(name="userId")
	private User userId;
	
	@NonNull
	@Column(nullable = false)
	private String noticeTitle;
	
	@NonNull
	@Column(nullable = false)
	private String noticeContent;
	
	@NonNull
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")
	@Column(nullable = false )
	private Date noticeRegdate;
	
	@NonNull
	@Column(nullable = false)
	private Integer noticeCategory;
	
	@Column(nullable = true)
	private String noticeImage;

}