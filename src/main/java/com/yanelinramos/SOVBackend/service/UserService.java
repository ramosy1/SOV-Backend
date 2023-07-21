package com.yanelinramos.SOVBackend.service;

import com.yanelinramos.SOVBackend.controller.DTO.UserDTO;
import com.yanelinramos.SOVBackend.model.User;

import java.util.List;

public interface UserService {

    boolean saveUserDataInDB(UserDTO userDTO);

    List<User> allUsers();

    User findById(Integer id);

    boolean updateUserDataInDB(UserDTO userDTO);

    void deleteUserDataInDB(Integer id);
}
