package com.connect.Connect.entries;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "profile_entry")
@Data
public class ProfileEntry
{

    @Id
    private ObjectId id;

}
