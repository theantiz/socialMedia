package xyz.antiz.socialMedia.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.antiz.socialMedia.model.*;
import xyz.antiz.socialMedia.respositories.SocialGroupRepository;
import xyz.antiz.socialMedia.respositories.SocialUserRepository;

import java.util.Set;

@Configuration
public class DataInit {

    @Bean
    CommandLineRunner initData(SocialUserRepository userRepo,
                               SocialGroupRepository groupRepo) {

        return args -> {
            if (userRepo.count() > 0) return;

            SocialGroup javaGroup = groupRepo.save(new SocialGroup());
            SocialGroup springGroup = groupRepo.save(new SocialGroup());

            SocialUser u1 = new SocialUser();

            SocialProfile p1 = new SocialProfile();
            p1.setUser(u1);
            u1.setSocialProfile(p1);

            Post post1 = new Post();
            post1.setSocialUser(u1);

            Post post2 = new Post();
            post2.setSocialUser(u1);

            u1.getPost().add(post1);
            u1.getPost().add(post2);

            u1.setGroups(Set.of(javaGroup, springGroup));
            userRepo.save(u1);

            SocialUser u2 = new SocialUser();

            SocialProfile p2 = new SocialProfile();
            p2.setUser(u2);
            u2.setSocialProfile(p2);

            u2.setGroups(Set.of(javaGroup));
            userRepo.save(u2);
        };
    }
}
