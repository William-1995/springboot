package com.inaction.repository.mongo;


import com.inaction.model.po.MongoUserPo;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MongoUserRepository extends MongoRepository<MongoUserPo, String> {

    @Query("{name:'?0'}")
    MongoUserPo findUserByName(String name);

    @DeleteQuery("{name:'?0'}")
    void deleteUserByName(String name);
}
