package com.coding.dao2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coding.entity.Role;




@Repository
public interface IRoleDao extends JpaRepository<Role, Integer> {
public Role findByName(String roleName);
}
