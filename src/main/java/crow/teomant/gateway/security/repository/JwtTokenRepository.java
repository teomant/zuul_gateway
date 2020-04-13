package crow.teomant.gateway.security.repository;

import crow.teomant.gateway.security.entity.JwtToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JwtTokenRepository extends JpaRepository<JwtToken, String> {
}
