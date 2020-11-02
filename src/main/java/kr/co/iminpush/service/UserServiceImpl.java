package kr.co.iminpush.service;


import kr.co.iminpush.dto.UserDto;
import kr.co.iminpush.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper dao;

    @Override
    public List<UserDto> printUser(){
        List<UserDto> users = dao.getUser();
        return users;
    }
}
