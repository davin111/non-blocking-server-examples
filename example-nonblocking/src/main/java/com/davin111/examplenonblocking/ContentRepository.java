package com.davin111.examplenonblocking;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ContentRepository extends ReactiveCrudRepository<Content, Long> {

    Flux<Content> findByIsPremiumFalse();

    Flux<Content> findByIsPremiumTrue();
}
