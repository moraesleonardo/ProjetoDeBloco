package info.moraes.carroservice.controller;



import info.moraes.carroservice.model.Carro;
import info.moraes.carroservice.service.CarroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class CarroController {
    private final CarroService carroService;
    @PostMapping
    public ResponseEntity<Carro> createCarro(@RequestBody Carro carro) {
        Carro saved = carroService.create(carro);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(carroService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        log.info("Find carro by id: {}", id);
        Optional<Carro> optional = carroService.findById(id);
        if(optional.isPresent()){
            return ResponseEntity.ok(optional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        carroService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Carro carro){
        carroService.update(carro);
        return ResponseEntity.ok().build();
    }

}