package hu.unideb.inf.WebProject.controller;

import hu.unideb.inf.WebProject.DTO.PerformerDTO;
import hu.unideb.inf.WebProject.service.PerformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/performers")
public class PerformerController {

    @Autowired
    PerformerService performerService;

    @PostMapping("/createPerformer")
    ResponseEntity createPerformer(@RequestBody PerformerDTO performerDTO) {
        return new ResponseEntity(performerService.create(performerDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    ResponseEntity getAllPerformers() {
        return new ResponseEntity<>(performerService.readAll(), HttpStatus.OK);
    }

    @PatchMapping("/updatePerformer")
    ResponseEntity updatePerformer(@RequestBody PerformerDTO performerDTO) {
        return new ResponseEntity(performerService.update(performerDTO), HttpStatus.OK);
    }

    @DeleteMapping("/deletePerformer")
    ResponseEntity deletePerformer(@RequestBody PerformerDTO performerDTO) {
        performerService.delete(performerDTO.performerId());
        return new ResponseEntity(HttpStatus.OK);
    }
}