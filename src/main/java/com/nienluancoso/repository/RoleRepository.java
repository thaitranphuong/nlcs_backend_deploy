package com.nienluancoso.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.nienluancoso.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

}
