package org.binar.kamihikoukiairlines.repository;

import org.binar.kamihikoukiairlines.model.Maskapai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaskapaiRepository extends JpaRepository<Maskapai, Long> {
}
