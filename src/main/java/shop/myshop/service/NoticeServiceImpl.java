package shop.myshop.service;

import java.sql.SQLException;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.myshop.entity.Notice;
import shop.myshop.repository.NoticeRepository;


@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeRepository noticedao;
	
	@Autowired
	private ModelMapper modelMapper;

	
	
	@Override
	public void saveNotice(Notice notice) throws SQLException {
	    noticedao.save(notice);
	}
	
	public List<Notice> getNotice() throws Exception {
		return noticedao.getNotice();
	}

	public List<Notice> findByNoticeNo(int noticeNo) throws Exception{
		return noticedao.findByNoticeNo(noticeNo);
	}
	
	public void deleteByNoticeNo(int noticeNo) throws Exception{
		noticedao.deleteByNoticeNo(noticeNo);
	}
    
}

	

	
	
	
