package br.thullyoo.poi.repository;

import br.thullyoo.poi.entity.Poi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PoiRepository extends JpaRepository<Poi, Long> {


    @Query("""
           SELECT p FROM tb_poi p
           WHERE ( p.x >= :xmin AND p.x <= :xmax AND p.y >= :ymin AND p.y <= :ymax)
           """)
    List<Poi> getAllDpoi(Long xmin, Long xmax, Long ymin, Long ymax );

}
