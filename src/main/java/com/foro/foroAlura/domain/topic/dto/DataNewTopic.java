package com.foro.foroAlura.domain.topic.dto;

import jakarta.validation.constraints.NotNull;

public record DataNewTopic(
    @NotNull
    String title,
    @NotNull
    String message,
    @NotNull
    Long author,
    @NotNull
    Long course

) {
}
