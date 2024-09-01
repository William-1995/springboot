package com.inaction.controller.mongo;

import com.inaction.model.po.MongoUserPo;
import com.inaction.service.mongo.MongoUserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("mongo/user")
public class MongoUserController {
    private final MongoUserService mongoUserService;
    public MongoUserController(MongoUserService mongoUserService) {
        this.mongoUserService = mongoUserService;
    }

    @GetMapping("/all")
    List<MongoUserPo> getUserById() {
        return mongoUserService.getAll();
    }

    @GetMapping("/{name}")
    MongoUserPo getUserByName(@PathVariable("name") String name) {
        return mongoUserService.getUserByName(name);
    }

    @PostMapping("/save")
    void saveUser(@RequestBody MongoUserPo mongoUserPo) {
        mongoUserService.saveUser(mongoUserPo);
    }

    @DeleteMapping("/{name}")
    void saveUser(@PathVariable("name") String name) {
        mongoUserService.deleteByName(name);
    }
}
