package com.foro.foroAlura.domain.topic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface topicRepository extends JpaRepository<Topic, Long> {
    
    boolean existsByTitle(String title);
    boolean existsByMessage(String message);
    Page<Topic> findAllByStatusTrue(Pageable pageable);


}
