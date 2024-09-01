package com.inaction.service.mongo;

import com.inaction.model.po.MongoUserPo;
import com.inaction.repository.mongo.MongoUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MongoUserService {

    private static final Logger logger = LoggerFactory.getLogger(MongoUserService.class);

    private final MongoUserRepository mongoUserRepository;

    public MongoUserService(MongoUserRepository mongoUserRepository) {
        this.mongoUserRepository = mongoUserRepository;
    }

    public List<MongoUserPo> getAll() {
        return this.mongoUserRepository.findAll();
    }

    public MongoUserPo getUserByName(String name) {
         return this.mongoUserRepository.findUserByName(name);
    }

    public void saveUser(MongoUserPo mongoUser) {
        logger.debug("Saving the user by ID: [{}].", mongoUser.getName());
        this.mongoUserRepository.save(mongoUser);
        logger.debug("Saved the user.");
    }

    public void deleteByName(String userName) {
        if (userName == null) {
            return ;
        }
        logger.debug("Deleting the user by name: [{}].", userName);
        this.mongoUserRepository.deleteUserByName(userName);
        logger.debug("Deleted the user.");
    }
}
