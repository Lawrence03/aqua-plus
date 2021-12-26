package icu.samnyan.aqua.sega.cardmaker.dao.mai;

import icu.samnyan.aqua.sega.cardmaker.model.mai.SellingCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("CardmakerMaiSellingCardRepository")
public interface SellingCardRepository extends JpaRepository<SellingCard, Long> {
}
