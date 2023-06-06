package shop.myshop.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotExistProductException extends Exception{
	public NotExistProductException(String msg) {
		super(msg); //getMessage() 데이터 활용
	}
}
