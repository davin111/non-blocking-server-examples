package com.davin111.exampleblocking;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends CrudRepository<Content, Long> {

    List<Content> findByIsPremiumFalse();

    List<Content> findByIsPremiumTrue();
}
