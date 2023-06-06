package shop.myshop.dto;

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
public class ProductDTO {
	private Integer productCode;
	private String productName;
	private String productPrice;
	private String productThumbnail;
	private String productImage1;
	private String productImage2;
	private String productPostingYn;
	private String productSaleingYn;
	private Integer productSize;
	private Integer productStock;
	private Integer productSale;
	private String productDetail;
}
