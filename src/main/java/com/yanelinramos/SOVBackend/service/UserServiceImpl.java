package com.yanelinramos.SOVBackend.service;

import com.yanelinramos.SOVBackend.controller.DTO.UserDTO;
import com.yanelinramos.SOVBackend.model.User;
import com.yanelinramos.SOVBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean saveUserDataInDB(UserDTO userDTO){
        User user = user(userDTO);
        User saved = userRepository.save(user);
        if(saved!=null)
            return true;
        return false;
    }

    private User user(UserDTO userDTO){
        User user=new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setAddress(userDTO.getAddress());
        user.setCity(userDTO.getCity());
        user.setState(userDTO.getState());
        user.setZipcode(userDTO.getZipcode());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    @Override
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        Optional<User> findById = userRepository.findById(id);
        if(findById.isPresent())
            return findById.get();
        return null;
    }

    @Override
    public boolean updateUserDataInDB(UserDTO userDTO) {
        Integer id = userDTO.getId();
        Optional<User> findById = userRepository.findById(id);
        if(findById.isPresent()){
            User user = findById.get();
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setAddress(userDTO.getAddress());
            user.setCity(userDTO.getCity());
            user.setState(userDTO.getState());
            user.setZipcode(userDTO.getZipcode());
            user.setPhoneNumber(userDTO.getPhoneNumber());
            user.setEmail(userDTO.getEmail());

            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public void deleteUserDataInDB(Integer id) {
        Optional<User> finById = userRepository.findById(id);
        if (finById.isPresent()){
            User user = finById.get();
            userRepository.delete(user);
        }
    }


}
