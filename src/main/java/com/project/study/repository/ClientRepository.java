package com.project.study.repository;

import com.project.study.domain.EClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<EClient, Long> {
}
