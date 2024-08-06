package com.coding.dao2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coding.entity.User;





@Repository
public interface IUserDao extends JpaRepository<User, Long> {
	
	
	public User findByUsername(String username);

}
