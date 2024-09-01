package com.inaction.model.po;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userCollection")
@Getter
@Setter
public class MongoUserPo {
    @Id
    private String id;
    private String name;
    private String sex;
}
