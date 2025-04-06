package com.connect.Connect.repositories;

import com.connect.Connect.entries.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableMongoRepositories
public interface UserRepository extends MongoRepository<User, ObjectId> {

    String findByusername(String username);
}
