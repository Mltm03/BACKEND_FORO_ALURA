package com.foro.foroAlura.domain.topic.dto;

import jakarta.validation.constraints.NotNull;

public record DataUpdateTopic(
    
    @NotNull
    String title,
    @NotNull
    String message
) {
    
    
}
