package com.test.web.service;

import com.test.web.entity.UserEntity;
import com.test.web.repository.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MainService {

    @Autowired
    private MainRepository mainRepository;

    public UserEntity addUser(String name,String email){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setEmail(email);
        return mainRepository.save(userEntity);
    }

    public List<UserEntity> getAllUser(){
        return mainRepository.findAll();
    }

    public UserEntity updateUser(Long id,String name,String email){
        Optional<UserEntity> optionalUserEntity = mainRepository.findById(id);
        if(optionalUserEntity.isPresent()){
            UserEntity userEntity = optionalUserEntity.get();
            userEntity.setName(name);
            userEntity.setEmail(email);
            return mainRepository.save(userEntity);
        }else {
            return null;
        }
    }

    public UserEntity deleteUser(Long id){
        Optional<UserEntity> optionalUserEntity = mainRepository.findById(id);
        if(optionalUserEntity.isPresent()){
            UserEntity userEntity = optionalUserEntity.get();
            mainRepository.delete(userEntity);
            return userEntity;
        }else  {
            return null;
        }
    }
}
