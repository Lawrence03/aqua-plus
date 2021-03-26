package icu.samnyan.aqua.sega.general.dao;

import icu.samnyan.aqua.sega.general.model.AllowKeychip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Repository
public interface AllowKeychipRepository extends JpaRepository<AllowKeychip, String> {
    boolean existsByKeychipId(String keychip);
    List<AllowKeychip> findByKeychipId(String keychip);
}