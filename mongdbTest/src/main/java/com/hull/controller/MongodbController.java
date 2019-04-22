package com.hull.controller;

/**
 * @author
 * @create 2019-04-22 21:26
 **/

import com.hull.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mongodb")
public class MongodbController {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**表名*/
    private static final String collectionName = "user";

    /**
     * 描述：新增
     * @author maochengyuan
     * @created 2018/9/1 20:17
     * @param user
     * @return ResultObject
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public String insert(@ModelAttribute User user) {
        this.mongoTemplate.insert(user);
        return "success";
    }

    /**
     * 描述：删除
     * @author maochengyuan
     * @created 2018/9/1 20:17
     * @param userId
     * @return ResultObject
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam("userId") String userId) {
        Query query = Query.query(Criteria.where("userId").is(userId));
        this.mongoTemplate.remove(query, collectionName);
        return "success";
    }

    /**
     * 描述：修改
     * @author maochengyuan
     * @created 2018/9/1 20:17
     * @param user
     * @return ResultObject
      */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(@ModelAttribute User user) {
        Query query = Query.query(Criteria.where("userId").is(user.getUserId()));
        Update update = new Update();
        update.set("age", user.getAge());
        update.set("name", user.getName());
        update.set("email", user.getEmail());
        this.mongoTemplate.updateFirst(query, update, collectionName);
        return "success";
    }

    /**
     * 描述：查询
     * @author maochengyuan
     * @created 2018/9/1 20:17
     * @param
     * @return ResultObject
     */
    @RequestMapping("/query")
    @ResponseBody
    public String query() {
        Query query = Query.query(Criteria.where("dataStatus").is(1));
        List<User> users = this.mongoTemplate.find(query, User.class);
        return users.toString();
    }


}
