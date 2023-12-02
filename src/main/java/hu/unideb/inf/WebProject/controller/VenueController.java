package hu.unideb.inf.WebProject.controller;

import hu.unideb.inf.WebProject.DTO.VenueDTO;
import hu.unideb.inf.WebProject.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/venues")
public class VenueController {

    @Autowired
    VenueService venueService;

    @PostMapping("/createVenue")
    ResponseEntity createVenue(@RequestBody VenueDTO venueDTO) {
        return new ResponseEntity(venueService.create(venueDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    ResponseEntity getAllVenues() {
        return new ResponseEntity<>(venueService.readAll(), HttpStatus.OK);
    }

    @PatchMapping("/updateVenue")
    ResponseEntity updateVenue(@RequestBody VenueDTO venueDTO) {
        return new ResponseEntity(venueService.update(venueDTO), HttpStatus.OK);
    }

    @DeleteMapping("/deleteVenue")
    ResponseEntity deleteVenue(@RequestBody VenueDTO venueDTO) {
        venueService.delete(venueDTO.venueId());
        return new ResponseEntity(HttpStatus.OK);
    }
}