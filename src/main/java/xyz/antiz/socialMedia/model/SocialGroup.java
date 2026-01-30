package xyz.antiz.socialMedia.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class SocialGroup {

    @ManyToMany(mappedBy = "groups")
    private Set<SocialUser> socialUsers = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
