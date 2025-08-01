package com.foro.foroAlura.domain.response;

import java.time.LocalDateTime;

import com.foro.foroAlura.domain.topic.Topic;
import com.foro.foroAlura.domain.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "responses")
@Entity(name = "Response")
@EqualsAndHashCode(of = "id")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter


public class Response {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String message;

    @ManyToOne
    private Topic topic;
    private LocalDateTime createdAt;

    @OneToOne
    private User author;
    private Boolean solution; 
}
