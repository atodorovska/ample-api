package mk.ukim.finki.ampleapi.controller;

import mk.ukim.finki.ampleapi.service.PersonTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test/person/all")
public class PersonTestController {

    @Autowired
    private PersonTestService personTestService;

    @GetMapping
    public ResponseEntity getAll(){
        return this.personTestService.getAll().map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
