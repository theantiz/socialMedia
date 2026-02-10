package xyz.antiz.socialMedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.antiz.socialMedia.model.SocialUser;
import xyz.antiz.socialMedia.service.SocialService;

import java.util.List;

@RestController
public class SocialController {

    @Autowired
    private SocialService socialService;

    @GetMapping("/test")
    public String testAPI() {
        return "API working";
    }

    @GetMapping("/social/users")
    public ResponseEntity<List<SocialUser>> getUsers() {
        return new ResponseEntity<>(socialService.getAllUser(), HttpStatus.OK);
    }

    @GetMapping("/social/user/{id}")
    public ResponseEntity<SocialUser> getUserById(@PathVariable Long id) {
        return socialService.getUserById(id)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/social/user")
    public ResponseEntity<SocialUser> saveUser(@RequestBody SocialUser socialUser) {
        SocialUser savedUser = socialService.saveUser(socialUser);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PutMapping("/social/user/{id}")
    public ResponseEntity<SocialUser> updateUser(@PathVariable Long id,
                                                 @RequestBody SocialUser socialUser) {
        return socialService.updateUser(id, socialUser)
                .map(updatedUser -> new ResponseEntity<>(updatedUser, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/social/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        boolean isDeleted = socialService.deleteUserById(id);
        if (isDeleted) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
