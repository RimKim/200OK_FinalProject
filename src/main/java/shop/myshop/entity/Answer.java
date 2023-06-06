package shop.myshop.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
@DynamicInsert   //(insert 시 null 인필드 제외)
@DynamicUpdate //(update 시 null 인필드 제외)
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer answerNo;
	
	@NonNull
	@Column(nullable = false)
	private String answerContent;
	
	@NonNull
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date answerRegdate;
	
	
	
	@OneToOne
	@NonNull
	@JoinColumn(name="questionNo")
	private Question questionNo;
	
}
