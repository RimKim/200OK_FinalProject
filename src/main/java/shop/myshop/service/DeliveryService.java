package shop.myshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import shop.myshop.dto.DeliveryDTO;
import shop.myshop.entity.Delivery;

@Transactional
@Service
public interface DeliveryService {

	public List<Delivery> getByUserId(String userId) throws Exception;

	public DeliveryDTO save(DeliveryDTO deliveryDTO);

	public Integer getByDeliveryId(String userId) throws Exception;

	public void updateBasicyn(int deliveryId) throws Exception;

	public DeliveryDTO findByDeliveryId(int deliveryId) throws Exception;

	public void deleteByDeliveryId(int deliveryId) throws Exception;
	
	public Delivery findBydeliveryBasicynAndDeliveryId(String userId) throws Exception;
}
