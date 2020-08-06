package com.cn.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cn.mybatisplus.mapper.UserMapper;
import com.cn.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisplusApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    //测试查询用map方式
    @Test
    public void testSelect(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","测试");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }
    //用批量查询
    @Test
    public void testSelect1(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("测试");
        user.setAge(52);
        user.setEmail("测试邮箱");
        int result = userMapper.insert(user); // 帮我们自动生成id
        System.out.println(result); // 受影响的行数
        System.out.println(user); // 发现，id会自动回填
    }
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(5L);
        user.setName("更新测试");

        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    //测试乐观锁
    /*
    若出现多线程操作执行，则执行插入操作的那条记录

     */
    @Test
    public void testOptimisticLocker(){
        //先查询一条记录
        User user = userMapper.selectById(1L);
        //修改信息
        user.setName("乐观锁测试");
        //更新操作
        userMapper.updateById(user);
    }
    @Test
    public void testDelete(){
        userMapper.deleteById(1291250663728214017L);
    }

    //测试分页
    @Test
    public void testPage(){
        Page<User> page = new Page<>(1,5);
        userMapper.selectPage(page,null);
        page.getRecords().forEach(System.out::println);

    }

}
