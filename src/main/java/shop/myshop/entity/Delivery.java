package shop.myshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Delivery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deliveryId;	
	
	@NonNull
	@Column(nullable = false)
	private String deliveryName;	
	
	@NonNull
	@Column(nullable = false)
	private String deliveryMobile;	
	
	@NonNull
	@Column(nullable = false)
	private String deliveryAdd1;
	
	@NonNull
	@Column(nullable = false)
	private String deliveryAdd2;
	
	@NonNull
	@Column(nullable = true)
	private String deliveryAdd3;
	
	private String deliveryBasicyn;
	
	@Column(nullable = true)
	private String deliveryMemo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@NonNull
	@JoinColumn(name="userId")
	private User userId;
	
	
	@Override
	public String toString() {
	return "Delivery{" +
	"deliveryId=" + deliveryId +
	", deliveryName='" + deliveryName + ' ' +
	", deliveryMobile='" + deliveryMobile + ' ' +
	", deliveryAdd1='" + deliveryAdd1 + ' ' +
	", deliveryAdd2='" + deliveryAdd2 + ' ' +
	", deliveryAdd3='" + deliveryAdd3 + ' ' +
	", deliveryBasicYn='" + deliveryBasicyn + ' ' +
	", deliveryMemo='" + deliveryMemo + ' ' +
	", userId='" + userId.getUserId() + ' ' +
	'}';
	}
	
}
