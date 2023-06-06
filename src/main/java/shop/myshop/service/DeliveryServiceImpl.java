package shop.myshop.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.myshop.dto.DeliveryDTO;
import shop.myshop.entity.Delivery;
import shop.myshop.repository.DeliveryRepository;

@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	private DeliveryRepository deliveryDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<Delivery> getByUserId(String userId) throws Exception {
		return deliveryDao.getByUserId(userId);
	}

	@Override
	public DeliveryDTO save(DeliveryDTO deliveryDTO) {
		Delivery delivery = modelMapper.map(deliveryDTO, Delivery.class);
		delivery = deliveryDao.save(delivery);
		return modelMapper.map(delivery, DeliveryDTO.class);
	}

	@Override
	public Integer getByDeliveryId(@Param("userId") String userId) throws Exception {
		return deliveryDao.getByDeliveryId(userId);
	}

	@Override
	public void updateBasicyn(@Param("deliveryId") int deliveryId) throws Exception {
		deliveryDao.updateBasicyn(deliveryId);
	}

	@Override
	public DeliveryDTO findByDeliveryId(int deliveryId) throws Exception {
		Delivery delivery = deliveryDao.findById(deliveryId)
				.orElseThrow(() -> new Exception("배송지가 존재하지 않습니다."));
		
		DeliveryDTO deliveryDTO = modelMapper.map(delivery, DeliveryDTO.class);
		return deliveryDTO;
	}
	
	@Override
	public void deleteByDeliveryId(int deliveryId) throws Exception{
		deliveryDao.deleteByDeliveryId(deliveryId);
	}

	@Override
	public Delivery findBydeliveryBasicynAndDeliveryId(String userId) throws Exception {
		
		return deliveryDao.findBydeliveryBasicynAndDeliveryId(userId);
	}

}
