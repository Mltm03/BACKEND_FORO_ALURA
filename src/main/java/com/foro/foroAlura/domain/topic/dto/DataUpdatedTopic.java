package com.foro.foroAlura.domain.topic.dto;

import com.foro.foroAlura.domain.topic.Topic;

public record DataUpdatedTopic(

    Long id,
    String title,
    String message,
    String author

) {

    public DataUpdatedTopic(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getAuthor().getEmail());
    }
} 