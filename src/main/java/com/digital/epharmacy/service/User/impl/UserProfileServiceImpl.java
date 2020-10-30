package com.digital.epharmacy.service.User.impl;
/*
* Author: Nicole Hawthorne
* Date: 02/09/2020
* Desc: Implementation for all userprofile methods
* */
import com.digital.epharmacy.controller.ExceptionHandler.MyCustomExceptionHandler;
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.repository.User.UserProfileRepository;
import com.digital.epharmacy.service.User.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepository repository;

    @Override
    public Set<UserProfile> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public UserProfile findUserProfileByUserName(String userName) {
        UserProfile userProfile = repository.findUserProfileByUserName(userName);

        if(userName == null)
            throw new MyCustomExceptionHandler("Name not found");

        return userProfile;
    }

    @Override
    public UserProfile findUserProfileByUserSurname(String userSurname) {
        UserProfile userProfile = repository.findUserProfileByUserSurname(userSurname);

        if(userSurname == null)
            throw new MyCustomExceptionHandler("Surname not found");

        return userProfile;
    }

    @Override
    public UserProfile create(UserProfile userProfile) {
        try{
            return this.repository.save(userProfile);
        } catch (Exception e){
            throw new MyCustomExceptionHandler("User '" + userProfile.getUserId() + "' already exists");
        }
    }

    @Override
    public UserProfile read(String s) {
        UserProfile userProfile = repository.findById(s).orElseGet(null);


        if (userProfile == null)
            throw new MyCustomExceptionHandler("Username or id does not exist");

        return userProfile;
    }

    @Override
    public UserProfile update(UserProfile userProfile) {
        return this.repository.save(userProfile);
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if (this.repository.existsById(s))
            return false;
        return true;
    }
}
