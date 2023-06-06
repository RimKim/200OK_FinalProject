package shop.myshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryNo;
	
	@NonNull
	@Column(nullable = false)
	private String categoryMain;
	
	@NonNull
	@Column(nullable = false)
	private String categorySub;
	
	
	@OneToMany(mappedBy = "categoryNo")
	private List<Product> product = new ArrayList<Product>();
	
}
