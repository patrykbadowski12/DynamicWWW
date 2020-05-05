package com.studia.backend.controller;

import com.studia.backend.entity.EncyclopediaEntity;
import com.studia.backend.service.BookService;
import com.studia.backend.service.EncyclopediaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
@RequiredArgsConstructor
public class EncyclopediaController {
    private final EncyclopediaService encyclopediaService;

    @GetMapping("/encyclopedia/{id}")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity<EncyclopediaEntity> getEncyclopedia(@PathVariable Long id){
      EncyclopediaEntity encyclopedia = encyclopediaService.getEncyclopedia(id);
      if (encyclopedia != null) {
          return new ResponseEntity<>(encyclopedia, HttpStatus.OK);
      }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
