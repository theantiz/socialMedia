package xyz.antiz.socialMedia.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class SocialUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "user")
    private SocialProfile socialProfile;

    @OneToMany
    private List<Post> post = new ArrayList<>();
}
