package com.source.comic.repository;

import com.source.comic.domain.EPublisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<EPublisher, Long> {
}
