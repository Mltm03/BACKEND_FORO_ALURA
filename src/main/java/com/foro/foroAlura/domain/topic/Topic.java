package com.foro.foroAlura.domain.topic;


import java.time.LocalDateTime;
import java.util.List;

import com.foro.foroAlura.domain.course.Course;
import com.foro.foroAlura.domain.response.Response;
import com.foro.foroAlura.domain.topic.dto.DataNewTopic;
import com.foro.foroAlura.domain.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "topics")
@Entity(name = "Topic")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate;
    private Boolean status;

    @ManyToOne
    private User author; 

    @ManyToOne
    private Course course; 

    @OneToMany(mappedBy = "topic" , cascade = CascadeType.ALL, orphanRemoval = true)
    private  List<Response> responses; 


    public Topic(DataNewTopic topic, User author,Course course ) {
        this.title=topic.title();
        this.message=topic.message();
        this.creationDate=LocalDateTime.now();
        this.status=true;
        this.author=author;
        this.course=course;
    }


}
