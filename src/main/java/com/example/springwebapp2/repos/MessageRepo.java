package com.example.springwebapp2.repos;

import com.example.springwebapp2.domain.MessageEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<MessageEntity, Long> {
    List<MessageEntity> findByTag(String tag);
}
