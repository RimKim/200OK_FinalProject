package shop.myshop.entity;

import java.util.ArrayList;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productCode;

	@NonNull
	@Column(nullable = false)
	private String productName;

	@NonNull
	@Column(nullable = false)
	private String productPrice;

	@NonNull
	@Column(nullable = false)
	private String productThumbnail;

	@NonNull
	@Column(nullable = false)
	private String productImage1;

	@NonNull
	@Column(nullable = false)
	private String productImage2;

	@NonNull
	@Column(nullable = false)
	private String productPostingYn;

	@NonNull
	@Column(nullable = false)
	private String productSaleingYn;

	@NonNull
	@Column(nullable = false)
	private String productSize;

	@NonNull
	@Column(nullable = false)
	private Integer productStock;

	@NonNull
	@Column(nullable = false)
	private Integer productSale;

	@NonNull
	@Column(nullable = false)
	private String productDetail;

	@NonNull
	 @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryNo")
	private Category categoryNo;

	@OneToMany(mappedBy = "productCode")
	private List<Likes> likes = new ArrayList<Likes>();

	@OneToMany(mappedBy = "productCode")
	private List<Cart> cart = new ArrayList<Cart>();

	@OneToMany(mappedBy = "productCode", cascade = CascadeType.ALL)
	private List<Review> Review = new ArrayList<Review>();

	@OneToMany(mappedBy = "productCode", cascade = CascadeType.ALL)
	private List<ProductQuestion> productquestion = new ArrayList<ProductQuestion>();

	@OneToMany(mappedBy = "productCode", cascade = CascadeType.ALL)
	private List<OrderItem> orderitem = new ArrayList<OrderItem>();

	@Override
	public String toString() {
	    return "Product [productCode=" + productCode + ", productName=" + productName + ", productPrice=" + productPrice
	            + ", productThumbnail=" + productThumbnail + ", productImage1=" + productImage1 + ", productImage2="
	            + productImage2 + ", productPostingYn=" + productPostingYn + ", productSaleingYn=" + productSaleingYn
	            + ", productSize=" + productSize + ", productStock=" + productStock + ", productSale=" + productSale
	            + ", productDetail=" + productDetail + ", categoryNo=" + categoryNo.getCategoryNo() + "]";
	}

}
