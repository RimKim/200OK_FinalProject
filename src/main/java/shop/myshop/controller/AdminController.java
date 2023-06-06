package shop.myshop.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import shop.myshop.annotation.MySecured;
import shop.myshop.dto.Role;
import shop.myshop.dto.UserDTO;
import shop.myshop.entity.Orders;
import shop.myshop.entity.Product;
import shop.myshop.entity.User;
import shop.myshop.service.OrdersService;
import shop.myshop.service.ProductService;
import shop.myshop.service.UserService;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	@Autowired
	private OrdersService ordersService;

	@MySecured(role = Role.ADMIN)
	@GetMapping("adminhome")
	public String adminhome(Model model) throws Exception {
		//TOP5 상품 차트
	    List<String> products = productService.findTop5ByOrderByProductSaleDesc();
	    ObjectMapper mapper = new ObjectMapper();
	    String productsJson = mapper.writeValueAsString(products);
	    model.addAttribute("products", productsJson);
	    
	    //worst5 상품 차트
	    List<String> worstproducts = productService.findWorst5ByOrderByProductSaleAsc();
	    String worstProductsJson = mapper.writeValueAsString(worstproducts);
	    model.addAttribute("worstproducts", worstProductsJson);
	    
	    //재고 10개 이하 상품
	    model.addAttribute("sale",  productService.findByProductSale());
	    
	    //최신 주문
	    model.addAttribute("orders", ordersService.findByRegDateDesc());
	   
	    
	    return "admin/admin-home";
	}
	

	// 회원관리 폼으로 이동
	@MySecured(role = Role.ADMIN)
	@GetMapping("usermanageform")
	public String userManageForm(Model model) throws Exception {

		model.addAttribute("user", userService.findAll());

		return "admin/user-manage";
	}

	// 상품관리 폼으로 이동
	@MySecured(role = Role.ADMIN)
	@GetMapping("productmanageform")
	public String productManageForm(Model model) throws Exception {

		model.addAttribute("product", productService.findProduct());

		return "admin/product-manage";
	}

	// 주문관리 폼으로 이동
	@MySecured(role = Role.ADMIN)
	@GetMapping("ordermanageform")
	public String orderManageForm(Model model) throws Exception {

		model.addAttribute("orders", ordersService.findOrder());

		return "admin/order-manage";
	}

	@MySecured(role = Role.ADMIN)
	@GetMapping("logout")
	public String logout(HttpSession httpSession) throws Exception {
		httpSession.invalidate();
		return "index";
	}

	// 메인으로 이동
	@MySecured(role = Role.ADMIN)
	@GetMapping("moveMain")
	public String moveMain(HttpSession httpSession) throws Exception {

		return "redirect:/main.html";
	}

	// 회원정보 수정 폼으로 이동
	@MySecured(role = Role.ADMIN)
	@GetMapping(value = "userupdateform")
	public String userUpdateForm(@RequestParam(name = "userId") String userId, Model model) throws Exception {
		System.out.println(userId);
		model.addAttribute("user", userService.findByUserId(userId));
		return "admin/user-update1";
	}

	// 회원정보 수정
	@MySecured(role = Role.ADMIN)
	@PostMapping("userupdate")
	public String userUpdate(User user) throws Exception {

		userService.join(user);

		return "redirect:/admin/usermanageform";
	}

	// 회원 삭제(비동기)
	@MySecured(role = Role.ADMIN)
	@GetMapping("userdelete")
	public String userDelete(@RequestParam(value = "userId") String userId) throws Exception {

		userService.deleteByUserId(userId);

		return "redirect:/admin/usermanageform";
	}

	// 상품정보 수정 폼으로 이동
	@MySecured(role = Role.ADMIN)
	@GetMapping(value = "productupdateform")
	public String productUpdateForm(@RequestParam(name = "productCode") int productCode, Model model) throws Exception {
		System.out.println(productCode);
		model.addAttribute("product", productService.findByProductCode(productCode));
		return "admin/product-update";
	}

	// 상품정보 수정
	@MySecured(role = Role.ADMIN)
	@PostMapping("productupdate")
	public String productUpdate(Product product) throws Exception {
		System.out.println("!!   " + product);
		productService.saveProduct(product);

		return "redirect:/admin/productmanageform";
	}

	// 상품 삭제(비동기)
	@MySecured(role = Role.ADMIN)
	@GetMapping("productdelete")
	public String productDelete(@RequestParam(value = "productCode") int productCode) throws Exception {

		productService.deleteProduct(productCode);

		return "redirect:/admin/productmanageform";
	}

	// 주문정보 수정 폼으로 이동
	@MySecured(role = Role.ADMIN)
	@GetMapping(value = "orderupdateform")
	public String orderUpdateForm(@RequestParam(name = "orderCode") int orderCode, Model model) throws Exception {
		System.out.println(orderCode);
		model.addAttribute("orders", ordersService.findByOrdersCode(orderCode));
		return "admin/order-update";
	}

	// 주문정보 수정
	@MySecured(role = Role.ADMIN)
	@PostMapping("orderupdate")
	public String orderUpdate(@RequestParam("orderCode") Integer orderCode, @RequestParam("userId") String userId,
			@RequestParam("orderRegdate") String orderRegdate, @RequestParam("orderPayment") String orderPayment,
			@RequestParam("orderStatus") String orderStatus, @RequestParam("orderTotalprice") String orderTotalprice,
			@RequestParam("deliveryName") String deliveryName, @RequestParam("deliveryMobile") String deliveryMobile,
			@RequestParam("deliveryAdd1") String deliveryAdd1, @RequestParam("deliveryAdd2") String deliveryAdd2,
			@RequestParam("deliveryAdd3") String deliveryAdd3, @RequestParam("deliveryMemo") String deliveryMemo)
			throws Exception {
		System.out.println("!!   " + orderRegdate);

		String dateString = orderRegdate;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		Date date = dateFormat.parse(dateString);
		UserDTO userDTO = userService.findByUserId(userId);
		ModelMapper modelMapper = new ModelMapper();
		User user = modelMapper.map(userDTO, User.class);

		Orders order = new Orders(orderCode, user, date, orderPayment, orderStatus, orderTotalprice, deliveryName,
				deliveryMobile, deliveryAdd1, deliveryAdd2, deliveryAdd3, deliveryMemo);

		ordersService.orderSave(order);

		return "redirect:/admin/ordermanageform";
	}

	// 주문 삭제(비동기)
	@MySecured(role = Role.ADMIN)
	@GetMapping("orderdelete")
	public String orderDelete(@RequestParam(value = "orderCode") String orderCode) throws Exception {
		System.out.println(orderCode);
		ordersService.deleteOrders(Integer.parseInt(orderCode));

		return "redirect:/admin/ordermanageform";
	}

}
