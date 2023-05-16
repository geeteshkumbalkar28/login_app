package net.codejava.repository;

import net.codejava.model.Oauth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OauthRepo extends JpaRepository<Oauth,Integer> {
}
