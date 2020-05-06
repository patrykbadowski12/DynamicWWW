package com.studia.backend.controller;

import com.studia.backend.entity.EncyclopediaEntity;
import com.studia.backend.service.BookService;
import com.studia.backend.service.EncyclopediaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
@RequiredArgsConstructor
public class EncyclopediaController {
    private final EncyclopediaService encyclopediaService;

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
}
