package com.foro.foroAlura.domain.topic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foro.foroAlura.domain.course.CourseRepository;
import com.foro.foroAlura.domain.topic.dto.DataNewTopic;
import com.foro.foroAlura.domain.topic.dto.DataUpdateTopic;
import com.foro.foroAlura.domain.user.userRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class topicServiceImpl implements topicService {

    @Autowired
    private topicRepository topicRepository;

    @Autowired
    private userRepository userRepository;
    
    @Autowired
    private CourseRepository courseRepository;



    @Override
    @Transactional
    public Topic saveTopic(DataNewTopic topic) {


        if(topicRepository.existsByTitle(topic.title())){
            throw new IllegalArgumentException("El título ya existe.");
        }

        if(topicRepository.existsByMessage(topic.message())){
            throw new IllegalArgumentException("El mensaje ya existe.");
        }


        var author=userRepository.getReferenceById(topic.author());
        var course=courseRepository.getReferenceById(topic.course());
        var newTopic=new Topic(topic, author,course);
        return topicRepository.save(newTopic);
    }

    @Override
    @Transactional(readOnly = true)
    public  Page<Topic> listTopics(Pageable pageable) {
        return topicRepository.findAllByStatusTrue(pageable);
    }
    
    @Override
    @Transactional
    public Topic updateTopic(Long id, DataUpdateTopic topic) {
        var topicToUpdateOpt=topicRepository.findById(id);

        if (topicToUpdateOpt.isEmpty()) {
            throw new EntityNotFoundException("El topic con id " + id + " no existe.");
        }
         if(topicRepository.existsByTitle(topic.title())){
            throw new IllegalArgumentException("El título ya existe.");
        }
        if(topicRepository.existsByMessage(topic.message())){
            throw new IllegalArgumentException("El mensaje ya existe.");
        }
        Topic topicToUpdate= topicToUpdateOpt.get();
        topicToUpdate.setTitle(topic.title());
        topicToUpdate.setMessage(topic.message());
        return topicRepository.save(topicToUpdate);


    }


    @Override
    @Transactional
    public Topic deleteTopic(Long id) {
        var topicToUpdateOpt=topicRepository.findById(id);

        if (topicToUpdateOpt.isEmpty()) {
            throw new EntityNotFoundException("El topic con id " + id + " no existe.");
        }

        Topic topic=topicToUpdateOpt.get();
        topic.setStatus(false);
        return topicRepository.save(topic);
        
    }

    @Override
    public Topic detailsTopic(Long id) {
        var topicToUpdateOpt=topicRepository.findById(id);

        if (topicToUpdateOpt.isEmpty()) {
            throw new EntityNotFoundException("El topic con id " + id + " no existe.");
        }
        return topicToUpdateOpt.get();
    }

    
}
