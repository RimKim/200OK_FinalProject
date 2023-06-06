package shop.myshop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer questionNo;
	
	@NonNull
	@Column(nullable = false)
	private String questionTitle;
	
	@NonNull
	@Column(nullable = false)
	private String questionContent;
	
	@NonNull
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date questionRegdate;
	
	@NonNull
	@Column(nullable = false)
	private String questionCategory;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@NonNull
	@JoinColumn(name="userId")
	private User userId;
	
	@OneToMany(mappedBy = "questionNo", cascade = CascadeType.ALL)
	private List<Answer> answer = new ArrayList<Answer>();

	
}