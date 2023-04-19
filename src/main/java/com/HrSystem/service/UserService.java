package com.HrSystem.service;

import com.HrSystem.entity.User;
import com.HrSystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserById(Integer id){
        User user = userMapper.selectById(id);
        return user;
    }

    public List<User> findUserByName(String name){
        HashMap<String, Object> queryMap = new HashMap<>();
        queryMap.put("name",name);
        List<User> users = userMapper.selectByMap(queryMap);
        return users;
    }

    public void insertUser(User user){
        userMapper.insert(user);
    }

    public void updateUser(User user){
        userMapper.updateById(user);
    }

    public List<User> findColleague(Integer leaderId){
        HashMap<String, Object> queryMap = new HashMap<>();
        queryMap.put("leader_id",leaderId);
        List<User> colleagues = userMapper.selectByMap(queryMap);
        if (!colleagues.isEmpty()){
            return colleagues;
        }
        return null;
    }

    public Map<String, Object> getOrgStructure(Integer userId){
        HashMap<String, Object> OrgStructureMap = new HashMap<>();
        User user = userMapper.selectById(userId);
        Integer leaderId = user.getLeaderId();
        User leader = userMapper.selectById(leaderId);
        List<User> leaders = new ArrayList<>();
        leaders.add(leader);
        OrgStructureMap.put("leader",leaders);
        List<User> myColleagues = this.findColleague(leaderId);
        OrgStructureMap.put("colleagues",myColleagues);
        List<User> underlings = this.findColleague(userId);
        OrgStructureMap.put("underlings",underlings);
        return OrgStructureMap;
    }

}
