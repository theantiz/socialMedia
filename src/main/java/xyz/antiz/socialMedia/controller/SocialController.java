package xyz.antiz.socialMedia.controller;

import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.antiz.socialMedia.model.SocialUser;
import xyz.antiz.socialMedia.service.SocialService;

import java.util.List;

@RestController
public class SocialController {
    @Autowired
    private SocialService socialService;

    @GetMapping("/social/users")
    public ResponseEntity<List<SocialUser>> getser() {
        return new ResponseEntity<>(socialService.getAllUser(), HttpStatus.OK);
    }

    @PostMapping("/social/user")
    public ResponseEntity<SocialUser> saveUser(@RequestBody SocialUser socialUser) {
        return new ResponseEntity<>(socialService.saveUser(socialUser), HttpStatus.CREATED);
    }
}
