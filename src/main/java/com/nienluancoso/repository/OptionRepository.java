package com.nienluancoso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nienluancoso.entity.OptionEntity;

public interface OptionRepository extends JpaRepository<OptionEntity, Long> {
}
