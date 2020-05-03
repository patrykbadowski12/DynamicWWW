package com.studia.backend.controller;

import com.studia.backend.entity.EncyclopediaEntity;
import com.studia.backend.service.BookService;
import com.studia.backend.service.EncyclopediaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class EncyclopediaController {
    private final EncyclopediaService encyclopediaService;

    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    @GetMapping("/encyclopedia/{id}")
    public EncyclopediaEntity getEncyclopedia(@PathVariable Long id){
      EncyclopediaEntity encyclopedia = encyclopediaService.getEncyclopedia(id);
      return encyclopedia;
    }


}
