package br.thullyoo.poi.controller;

import br.thullyoo.poi.entity.DTO.RequestDpoi;
import br.thullyoo.poi.entity.Poi;
import br.thullyoo.poi.entity.DTO.RequestPoi;
import br.thullyoo.poi.repository.PoiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/poi")
public class PoiController {

    @Autowired
    private PoiRepository poiRepository;

    @GetMapping()
    public ResponseEntity<List<Poi>> getAllPoi(){
        var listPoi = poiRepository.findAll();
        return ResponseEntity.ok(listPoi);
    }

    @PostMapping("/save")
    public ResponseEntity<Poi> savePoi(@RequestBody RequestPoi request){
        Poi poi = poiRepository.save(new Poi(request.name(), request.x(), request.y()));
        return ResponseEntity.ok(poi);
    }

    @GetMapping("/getDmax")
    public ResponseEntity<List<Poi>> getDmax(@RequestBody RequestDpoi requestDpoi){
        Long xmin = requestDpoi.x() - requestDpoi.dmax();
        Long xmax = requestDpoi.x() + requestDpoi.dmax();
        Long ymin = requestDpoi.y() - requestDpoi.dmax();
        Long ymax = requestDpoi.y() + requestDpoi.dmax();

        List<Poi> listPoi = poiRepository.getAllDpoi(xmin, xmax, ymin, ymax)
                .stream()
                .filter(poi -> {
                    return getDistance(poi.getX(), requestDpoi.x(), poi.getY(), requestDpoi.y()) < requestDpoi.dmax();
                })
                .toList();

        return ResponseEntity.ok(listPoi);
    }

    private Double getDistance(Long x1, Long x2, Long y1, Long y2){
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
