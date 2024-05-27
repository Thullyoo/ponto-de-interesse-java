package br.thullyoo.poi.repository;

import br.thullyoo.poi.entity.Poi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoiRepository extends JpaRepository<Poi, Long> {
}
