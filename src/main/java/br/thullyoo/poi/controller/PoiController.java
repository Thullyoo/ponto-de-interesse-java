package br.thullyoo.poi.controller;

import br.thullyoo.poi.entity.Poi;
import br.thullyoo.poi.entity.DTO.RequestPoi;
import br.thullyoo.poi.repository.PoiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/poi")
public class PoiController {

    @Autowired
    private PoiRepository poiRepository;

    @GetMapping
    public ResponseEntity<List<Poi>> getAllPoi(){
        List<Poi> listPoi = poiRepository.findAll();
        return ResponseEntity.ok(listPoi);
    }

    @PostMapping("/save")
    public ResponseEntity<Poi> savePoi(@RequestBody RequestPoi request){
        Poi poi = poiRepository.save(new Poi(request.name(), request.x(), request.y()));
        return ResponseEntity.ok(poi);
    }
}
