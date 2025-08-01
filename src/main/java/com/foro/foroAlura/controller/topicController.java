package com.foro.foroAlura.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foro.foroAlura.domain.topic.Topic;
import com.foro.foroAlura.domain.topic.topicService;
import com.foro.foroAlura.domain.topic.dto.DataFromTopic;
import com.foro.foroAlura.domain.topic.dto.DataNewTopic;
import com.foro.foroAlura.domain.topic.dto.DataUpdateTopic;
import com.foro.foroAlura.domain.topic.dto.DataUpdatedTopic;
import com.foro.foroAlura.domain.topic.dto.ListAllTopic;

import jakarta.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;







@RestController
@RequestMapping("/topics")
public class topicController {

    @Autowired
    private topicService topicService;

    


    @PostMapping
    public ResponseEntity<DataFromTopic> createTopic(@RequestBody @Valid DataNewTopic topic) {

        var newTopic=topicService.saveTopic(topic);
        return ResponseEntity.ok(new DataFromTopic(newTopic));
    }
    
    @GetMapping
    public ResponseEntity<Page <ListAllTopic>> listTopics(@PageableDefault(size = 1) Pageable pageable) {

        // List<ListAllTopic> result=topicService.listTopics()
        //     .stream()
        //     .map(ListAllTopic::new)
        //     .toList();
        //de esta forma era sin paginacion, pasando directamente una lista y mapenadola para convertirla al dto

        return ResponseEntity.ok(topicService.listTopics(pageable).map(ListAllTopic::new));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataUpdatedTopic> updateTopic( @PathVariable Long id, @RequestBody @Valid DataUpdateTopic dataUpdateTopic) {

        Topic topic=topicService.updateTopic(id, dataUpdateTopic);
        return ResponseEntity.ok(new DataUpdatedTopic(topic));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
        return ResponseEntity
        .status(HttpStatus.OK)
        .body("El topic fue marcado como inactivo existosamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListAllTopic> getTopic(@PathVariable Long id) {
        Topic topic= topicService.detailsTopic(id);
        return ResponseEntity.ok(new ListAllTopic(topic));
    }
    
    

}
