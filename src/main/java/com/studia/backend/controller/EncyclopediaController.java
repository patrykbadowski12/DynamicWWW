package com.studia.backend.controller;

import com.studia.backend.entity.EncyclopediaEntity;
import com.studia.backend.entity.EncyclopediaRegistrationEntity;
import com.studia.backend.service.BookService;
import com.studia.backend.service.EncyclopediaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class EncyclopediaController {
    private final EncyclopediaService encyclopediaService;

    @GetMapping("/encyclopedies")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "jwtToken")})
    public ResponseEntity<List<EncyclopediaEntity>> getEncyclopedia() {
        List<EncyclopediaEntity> encyclopedia = encyclopediaService.getAllEncyclopedies();
        if (!encyclopedia.isEmpty()) {
            return new ResponseEntity<>(encyclopedia, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/encyclopedia/{id}")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "jwtToken")})
    public ResponseEntity<EncyclopediaEntity> getEncyclopedia(@PathVariable Long id) {
        EncyclopediaEntity encyclopedia = encyclopediaService.getEncyclopedia(id);
        if (encyclopedia != null) {
            return new ResponseEntity<>(encyclopedia, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/encyclopedia")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "jwtToken")})
    public ResponseEntity saveEncyclopedia(@RequestParam String title) {
        try {
            encyclopediaService.saveEncyclopedia(title);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/encyclopedia")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "jwtToken")})
    public ResponseEntity deleteEncyclopedia(@RequestParam Long id) {
        try {
            encyclopediaService.deleteEncyclopedia(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/encyclopedia/registry")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "jwtToken")})
    public ResponseEntity addRegistry(@RequestParam Long id, @RequestBody EncyclopediaRegistrationEntity registration) {
        try {
            encyclopediaService.addRegistry(id, registration);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }


}
