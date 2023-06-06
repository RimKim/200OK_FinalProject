package shop.myshop.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import shop.myshop.entity.Notice;


@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer> {

	
	List<Notice> findByNoticeNo(int noticeNo) throws Exception;

	//중요공지는 먼저 출력하되 글 순서 역순 정렬	
	@Query(value = "select n FROM Notice n ORDER BY noticeCategory ASC, noticeNo DESC")
	List<Notice> getNotice() throws Exception;
	
	@Modifying
	@Transactional
	void deleteByNoticeNo(int noticeNo);
	
}
