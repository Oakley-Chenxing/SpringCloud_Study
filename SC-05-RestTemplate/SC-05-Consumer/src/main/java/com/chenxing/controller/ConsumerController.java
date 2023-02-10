package com.chenxing.controller;

import com.chenxing.domian.User;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ConsumerController
 * @Description: TODO
 * @Author: lichenxingbeijing@163.com
 * @date ：Created in 09/02/2023 20:42
 */
@RestController
public class ConsumerController {
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/test00")
    public String test00(){
        String URL = "http://SC-05-Provider/test00";

        ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);

        String info = response.getBody();

        return "服务消费者正在消费 ===> " + info;
    }

    @RequestMapping("/test01")
    public String test01(){
        String URL = "http://SC-05-Provider/test01";

        ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);

        String info = response.getBody();

        return "服务消费者 test01 正在消费 ===> " + info;
    }

    @RequestMapping("/test02")
    public String test02(){
        String URL = "http://SC-05-Provider/test02";

        // ResponseEntity<Object> response = restTemplate.getForEntity(URL, Object.class);
        // Object user = response.getBody();

        // ResponseEntity<User> response = restTemplate.getForEntity(URL, User.class);
        // User user = response.getBody();
        // System.out.println("user.name = " + user.getName());
        // System.out.println("user.age = " + user.getAge());

        ResponseEntity<Map> response = restTemplate.getForEntity(URL, Map.class);
        Map user = response.getBody();

        System.out.println("user.get('name') = " + user.get("name"));
        System.out.println("user.get('age') = " + user.get("age"));

        return "服务消费者 test02 正在消费 ===> " + user;
    }

    @RequestMapping("/test03")
    public String test03(){
        String URL = "http://SC-05-Provider/test03";
        // 如果服务提供者返回的类型是 List 集合，实际上返回的是一个 Json 数组
        // 消费端接收到的 list 集合中元素的类型并不是服务提供者中提供的 User 类型，而是 LinkedHashMap 类型
        ResponseEntity<List> response = restTemplate.getForEntity(URL, List.class);

        List userList = response.getBody();

        for (Object user : userList) {
            System.out.println(user + "<===>" + user.getClass());
        }

        return "服务消费者 test03 正在消费 ===> " + userList;
    }

    @RequestMapping("test04")
    public String test04(User user){
        // 方法一
        // String URL = "http://SC-05-Provider/test04?name={0}&age={1}";
        //
        // ResponseEntity<User> response = restTemplate.getForEntity(URL, User.class, user.getName(), user.getAge());
        //
        // User resUser = response.getBody();
        // System.out.println(resUser.getName());
        // System.out.println(resUser.getAge());

        // 方法二
        String URL = "http://SC-05-Provider/test04?name={name}&age={age}";

        HashMap<String, Object> args = new HashMap<>();

        args.put("name", user.getName());
        args.put("age", user.getAge());

        ResponseEntity<User> response = restTemplate.getForEntity(URL, User.class, args);

        User resUser = response.getBody();

        System.out.println(resUser.getName());
        System.out.println(resUser.getAge());

        return "服务消费者 test04 正在消费 ===> " + resUser;
    }

    @RequestMapping("/test05")
    public String test05(){
        String URL = "http://SC-05-Provider/test05";

        User user = restTemplate.getForObject(URL, User.class);
        // ResponseEntity<User> response = restTemplate.getForEntity(URL, User.class);
        // User user = response.getBody();
        // System.out.println(response.getHeaders());
        // System.out.println(response.getStatusCode());
        // System.out.println(response.getStatusCodeValue());

        return "服务消费者 test05 正在消费 ===> " + user;
    }

    @RequestMapping("/test06")
    public String test06(User user){
        // String URL = "http://SC-05-Provider/test06?name={name}&age={age}";
        // HashMap<String, Object> args = new HashMap<>();
        // args.put("name", user.getName());
        // args.put("age", user.getAge());
        // User resUser = restTemplate.postForObject(URL, Object.class, User.class, args);

        String URL = "http://SC-05-Provider/test06";

        LinkedMultiValueMap<Object, Object> lmvm = new LinkedMultiValueMap<>();

        lmvm.add("name", user.getName());
        lmvm.add("age", user.getAge());

        User resUser = restTemplate.postForObject(URL, lmvm, User.class);

        return "Success + " + resUser; // resUser 得到的是一个空对象
    }

    @RequestMapping("/test07")
    public String test07(User user){
        // String URL = "http://SC-05-Provider/test07?name={name}&age={age}";
        // HashMap<String, Object> args = new HashMap<>();
        // args.put("name", user.getName());
        // args.put("age", user.getAge());
        // restTemplate.put(URL, Object.class, args);

        String URL = "http://SC-05-Provider/test07";
        LinkedMultiValueMap<Object, Object> lmvm = new LinkedMultiValueMap<>();

        // put 就是 map 集合中的常规添加元素方法，如果键不存在表示添加，存在表示修改
        // add 方法是 lmvm 对象中的新方法，如果键不存在表示添加，如果存在表示追加
        lmvm.add("name", user.getName());
        lmvm.add("age", user.getAge());
        restTemplate.put(URL, lmvm);

        return "Success Put";
    }

    @RequestMapping("/test08")
    public String test08(User user){
        // String URL = "http://SC-05-Provider/test08?name={0}&age={1}";
        // restTemplate.delete(URL, user.getName(), user.getAge());

        String URL = "http://SC-05-Provider/test08?name={name}&age={age}";
        HashMap<String, Object> args = new HashMap<>();
        args.put("name", user.getName());
        args.put("age", user.getAge());
        restTemplate.delete(URL, args);

        return "Success delete!~";
    }
}
