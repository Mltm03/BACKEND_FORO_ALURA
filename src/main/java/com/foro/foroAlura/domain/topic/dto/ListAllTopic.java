package com.foro.foroAlura.domain.topic.dto;

import java.time.LocalDateTime;
import com.foro.foroAlura.domain.topic.Topic;


public record ListAllTopic(
    String title,
    String message,
    LocalDateTime creationDate,
    Boolean status,
    String author,
    String course
) {

    public ListAllTopic(Topic topic){
        this(topic.getTitle(), topic.getMessage(), topic.getCreationDate(), topic.getStatus(), topic.getAuthor().getEmail(), topic.getCourse().getName());
    }
    
}
