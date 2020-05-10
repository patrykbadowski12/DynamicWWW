package com.studia.backend.controller;

import com.studia.backend.entity.BookEntity;
import com.studia.backend.service.AdminService;
import com.studia.backend.service.BookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final BookService bookService;
    private final AdminService adminService;

    @PostMapping("/book")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity createBook(@RequestBody BookEntity bookEntity){
        try {
            bookService.saveBook(bookEntity);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/delete")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity deleteData(){
        adminService.deleteData();
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/book/statistic")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity bookStatistic(@RequestParam String startDay, @RequestParam String endDay){
        adminService.releaseBookStatistic(startDay,endDay);
        return new ResponseEntity(HttpStatus.OK);
    }

}
