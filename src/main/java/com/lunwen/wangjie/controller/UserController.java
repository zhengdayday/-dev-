package com.lunwen.wangjie.controller;

import com.lunwen.wangjie.Utils.JwtToken;
import com.lunwen.wangjie.model.User;
import com.lunwen.wangjie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 通过名字获取User
     * @param userName name
     * @return User
     */
    @RequestMapping(value = "/byname",method = RequestMethod.GET)
    public User getUser(String userName) {
        return userService.getUserByName(userName);
    }

    /**
     * get all user
     * @return Mpa
     */
    @RequestMapping(value = "/allUser", method = RequestMethod.GET)
    public Map<String, Object> getAllUser() {
        Map<String, Object> map =  new HashMap<>();
        map.put("userlist", userService.getAllUser());
        return map;
    }

    /**
     * 学生注册
     * @param user 学生
     * @return boolean
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public boolean saveUser(@RequestBody User user){
        if(userService.saveUser(user)) {
            return false;
        } else {
            //邮箱已经被使用
            return true;
        }
    }

    /**
     * 教师注册
     * @param user 老师
     * @return boolean
     */
    @RequestMapping(value = "/saveTeacher",method = RequestMethod.POST)
    public boolean saveTeacher(@RequestBody User user){
        if(userService.saveTeacher(user)) {
            return false;
        } else {
            //邮箱已经被使用
            return true;
        }
    }

    /**
     * 登录
     * @param user user
     * @return map
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String, Object> login(@RequestBody User user) {
        User finUser = userService.login(user);
        Map<String, Object> map = new HashMap<>();
        if(finUser != null) {
            try {
                String token = JwtToken.createToken();
                // 登录成功后传给前端token, name , level
                map.put("token", token);
                map.put("name", finUser.getName());
                map.put("level", finUser.getLevel());
                map.put("number", finUser.getNumber());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}