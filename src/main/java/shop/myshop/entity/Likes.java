package shop.myshop.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Likes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer likeNo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@NonNull
	@JoinColumn(name="productCode")
	private Product productCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@NonNull
	@JoinColumn(name="userId")
	private User userId;
	
	
	@Override
	public String toString() {
	    return "Likes{" +
	            "likeNo=" + likeNo +
	            ", productCode=" + productCode.getProductName() +
	            ", userId=" + userId.getUserName() +
	            '}';
	}
}
