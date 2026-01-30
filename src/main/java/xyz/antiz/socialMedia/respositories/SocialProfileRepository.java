package xyz.antiz.socialMedia.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.antiz.socialMedia.model.SocialProfile;
import xyz.antiz.socialMedia.model.SocialUser;

public interface SocialProfileRepository extends JpaRepository<SocialProfile,Long> {
}
