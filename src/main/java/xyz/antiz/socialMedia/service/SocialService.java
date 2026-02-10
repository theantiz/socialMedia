package xyz.antiz.socialMedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.antiz.socialMedia.model.SocialUser;
import xyz.antiz.socialMedia.respositories.SocialUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SocialService {

    @Autowired
    private SocialUserRepository socialUserRepository;

    public List<SocialUser> getAllUser() {
        return socialUserRepository.findAll();
    }

    public Optional<SocialUser> getUserById(Long id) {
        return socialUserRepository.findById(id);
    }

    public SocialUser saveUser(SocialUser socialUser) {
        return socialUserRepository.save(socialUser);
    }

    public Optional<SocialUser> updateUser(Long id, SocialUser socialUser) {
        return socialUserRepository.findById(id).map(existingUser -> {
            socialUser.setId(id);
            return socialUserRepository.save(socialUser);
        });
    }

    public boolean deleteUserById(Long id) {
        if (!socialUserRepository.existsById(id)) return false;
        socialUserRepository.deleteById(id);
        return true;
    }
}
