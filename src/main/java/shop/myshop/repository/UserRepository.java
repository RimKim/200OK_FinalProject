package shop.myshop.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import shop.myshop.entity.User;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	List<User> findByUserIdAndUserPwd(String id, String pwd) throws Exception;

	User findByUserId(String id) throws Exception;

	@Query(value = "select u.userId from User u  where u.userName=:userName and u.userEmail=:userEmail")
	String findByUserNameAndUserEmail(@Param("userName") String userName, @Param("userEmail") String userEmail)
			throws Exception;

	@Query(value = "select u FROM User u where u.userId=:userId and u.userName=:userName and u.userEmail=:userEmail")
	User findByUserIdAndUserNameAndUserEmail(@Param("userId") String userId, @Param("userName") String userName,
			@Param("userEmail") String userEmail) throws Exception;

	@Query(value = "select u.userId from User u  where u.userId=:userId")
	Optional<User> existsByUserId(@Param("userId") String userId) throws Exception;
	
	@Modifying
	@Query(value = "update User u set u.userPwd=:userPwd where u.userId=:userId")
	int updateTempPwd(@Param("userPwd") String tempPwd, @Param("userId") String userId) throws Exception;
	

}
