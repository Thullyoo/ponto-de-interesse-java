package br.thullyoo.poi;

import br.thullyoo.poi.entity.Poi;
import br.thullyoo.poi.repository.PoiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PoiApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(PoiApplication.class, args);
	}

	@Autowired
	private PoiRepository poiRepository;

	@Override
	public void run(String... args) throws Exception {
		poiRepository.save(new Poi("Lanchonete",27L ,12L));
		poiRepository.save(new Poi("Posto", 31L,18L ));
		poiRepository.save(new Poi("Joalheria", 15L, 12L ));
		poiRepository.save(new Poi("Floricultura", 19L, 21L ));
		poiRepository.save(new Poi("Pub", 12L, 8L ));
		poiRepository.save(new Poi("Supermercado", 23L , 6L ));
		poiRepository.save(new Poi("Churrascaria", 28L , 2L ));
	}
}
