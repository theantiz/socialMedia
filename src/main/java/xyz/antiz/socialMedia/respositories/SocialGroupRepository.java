package xyz.antiz.socialMedia.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.antiz.socialMedia.model.SocialGroup;

public interface SocialGroupRepository extends JpaRepository<SocialGroup,Long> {
}
