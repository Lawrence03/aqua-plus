package icu.samnyan.aqua.sega.cardmaker.dao.ongeki;

import icu.samnyan.aqua.sega.cardmaker.model.ongeki.UserCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("CardmakerOngekiUserCardRepository")
public interface UserCardRepository extends JpaRepository<UserCard, Long> {
}
