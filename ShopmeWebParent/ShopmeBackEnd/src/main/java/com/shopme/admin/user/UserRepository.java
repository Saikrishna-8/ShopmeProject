package com.shopme.admin.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopme.common.entity.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

	@Query("select u from User u where u.email=:email")
	public User getUserByEmail(@Param("email") String email);

	public Long countById(Integer id);

	@Query("UPDATE User u SET u.enabled =?2 WHERE u.id=?1")
	@Modifying
	public void updateEnabledStatus(Integer id, boolean enabled);

	// above method is recommonded 
	@Query("UPDATE User SET enabled =?2 WHERE id=?1")
	@Modifying
	public void updateEnabledStatus1(Integer id, boolean b);
	
	@Query("select u from User u Where CONCAT(u.id,' ',u.email,' ',u.firstName,' ',u.lastName) LIKE %?1%")
	public Page<User> findAll(String keyword,Pageable pageable);

}
