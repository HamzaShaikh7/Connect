package com.connect.Connect.repositories;

import com.connect.Connect.entries.ConfigApiEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ConfigAPIRepository extends MongoRepository<ConfigApiEntry, ObjectId> {

}
