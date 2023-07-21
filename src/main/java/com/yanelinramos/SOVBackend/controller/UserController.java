package com.yanelinramos.SOVBackend.controller;

import com.yanelinramos.SOVBackend.controller.DTO.UserDTO;
import com.yanelinramos.SOVBackend.controller.DTO.UserResponse;
import com.yanelinramos.SOVBackend.model.User;
import com.yanelinramos.SOVBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin("*")
    @PostMapping("/")
    public ResponseEntity<UserResponse> addUser(@RequestBody UserDTO userDTO) {
        if(userService.saveUserDataInDB(userDTO))
            return ResponseEntity.status(HttpStatus.OK).body(new UserResponse("200", "User has been successfully added."));
        return ResponseEntity.status(HttpStatus.OK).body(new UserResponse("200", "User NOT added. Please try again!"));
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
       return userService.allUsers();
    }

    @CrossOrigin("*")
    @GetMapping("/{id}")
    public User findUserById( @PathVariable Integer id ) {
        return userService.findById(id);
    }


    @CrossOrigin("*")
    @PutMapping( "/{id}" )
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserDTO userDTO ) {
        if(userService.updateUserDataInDB(userDTO))
            return ResponseEntity.status(HttpStatus.OK).body(new UserResponse("200", "User has been successfully updated."));
        return ResponseEntity.status(HttpStatus.OK).body(new UserResponse("200", "User NOT updated. Please try again!"));
    }

    @CrossOrigin("*")
    @DeleteMapping( "/{id}" )
    public void deleteUser( @PathVariable Integer id ) {
        userService.deleteUserDataInDB( id );
    }
}
