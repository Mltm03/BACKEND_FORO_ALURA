package com.foro.foroAlura.domain.topic;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.foro.foroAlura.domain.topic.dto.DataNewTopic;
import com.foro.foroAlura.domain.topic.dto.DataUpdateTopic;

public interface topicService {
    
    public Topic saveTopic(DataNewTopic topic);
    public Page<Topic> listTopics(Pageable pageable);
    public Topic deleteTopic(Long id);
    public Topic updateTopic(Long id, DataUpdateTopic topic);
    public Topic detailsTopic(Long id);

}
