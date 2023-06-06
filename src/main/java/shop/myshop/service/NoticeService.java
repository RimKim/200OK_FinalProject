package shop.myshop.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import shop.myshop.entity.Notice;


@Transactional
@Service
public interface NoticeService {
	
	
	
	public void saveNotice(Notice notice) throws SQLException ;
	
	public List<Notice> getNotice() throws Exception;
	
	public List<Notice> findByNoticeNo(int noticeNo) throws Exception;
	
	void deleteByNoticeNo(int noticeNo) throws Exception;
}
