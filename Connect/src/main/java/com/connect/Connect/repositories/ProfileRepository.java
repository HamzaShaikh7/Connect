package com.connect.Connect.repositories;

import com.connect.Connect.entries.ProfileEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProfileRepository extends MongoRepository<ProfileEntry, ObjectId> {
}
