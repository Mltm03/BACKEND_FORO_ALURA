package com.foro.foroAlura.domain.topic.dto;

import com.foro.foroAlura.domain.topic.Topic;


public record DataFromTopic(
    Long id,
    String title,
    String author
) {
    public DataFromTopic(Topic topic){
        this(topic.getId(),topic.getTitle(),topic.getAuthor().getEmail());

    }
}
