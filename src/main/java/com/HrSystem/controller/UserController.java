package com.HrSystem.controller;

import com.HrSystem.common.pojo.Result;
import com.HrSystem.entity.User;
import com.HrSystem.service.TokenService;
import com.HrSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hrq
 * #Description ${NAME}
 * #Date:   2023/3/14
 */

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private TokenService tokenService;

    @GetMapping("/findbyid")
    public Result findUser(Integer userId){
        User user = userService.findUserById(userId);
        return Result.ok(user);
    }

    @GetMapping("/findLeaderById")
    public Result findLeader(Integer leaderId){
        User user = userService.findUserById(leaderId);
        return Result.ok(user);
    }

    @RequestMapping("/login")
    public Result login(@RequestBody User user, HttpServletResponse response){
        HashMap<String,String> map = new HashMap<>();
        User userById = userService.findUserById(user.getId());
        if (userById==null){
            return Result.error("账号为空");
        }
        String password1 = userById.getPassword();
        if (password1.equals(user.getPassword())){
            // 生成token
            String token = tokenService.getToken(userById);
            map.put("token",token);
            //增加管理员设置
            if (userById.getType()==1){
                String superToken = tokenService.getSuperToken(userById);
                map.put("superToken",superToken);
            }
            //尝试增加cookie
            Cookie cookie = new Cookie("user",userById.getId()+"#"+userById.getName());
            cookie.setMaxAge(3600*1);
            response.addCookie(cookie);
            return Result.ok(map);
        }
        return Result.error("密码错误");
    }

    @RequestMapping("/logout")
    public Result logout(HttpServletResponse response){
        // 删除cookie
        Cookie cookie = new Cookie("user","");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return Result.ok("退出登录成功");
    }

    @GetMapping("/searchuser")
    public Result searchUserByName(String name){
        List<User> users = userService.findUserByName(name);
        if (users.isEmpty()){
            return Result.error("没有员工名为： "+name);
        }
        return Result.ok(users);
    }

    @RequestMapping("/insertuser")
    public Result insertUser(@RequestBody User user){
        if(user.getName()==""||user.getPassword()==""){
            return Result.error("姓名和密码不能为空！");
        }
        userService.insertUser(user);
        List<User> users = userService.findUserByName(user.getName());
        Integer id = 0;
        for (User u:users
             ) {
            if (u.getId()>id)
            id = u.getId();
        }
        return Result.ok(id.toString());
    }

    @RequestMapping("/updateuser")
    public Result updateUser(@RequestBody User user){
        userService.updateUser(user);
        return Result.ok("编辑成功！");
    }

    @GetMapping("/checktoken")
    public Boolean checkToken(HttpServletRequest request){
        String token = request.getHeader("token");
        return tokenService.checkToken(token);
    }

    @GetMapping("/checksupertoken")
    public Boolean checkSuperToken(HttpServletRequest request){
        String token = request.getHeader("superToken");
        return tokenService.checkSuperToken(token);
    }

    @GetMapping("/getMyColleague")
    public Result getMyColleague(Integer leaderId){
        List<User> myColleagues = userService.findColleague(leaderId);
        if (myColleagues==null){
            return Result.error("你尚未有同组同事");
        }
        return Result.ok(myColleagues);
    }

    @GetMapping("/getOrgStructure")
    public Result getOrgStructure(Integer userId){
        Map<String, Object> orgStructure = userService.getOrgStructure(userId);
        if (orgStructure.isEmpty()){
            return Result.error("未查询到组织架构信息");
        }
        return Result.ok(orgStructure);
    }
}
