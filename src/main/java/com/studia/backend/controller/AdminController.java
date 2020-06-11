package com.studia.backend.controller;

import com.studia.backend.entity.BookEntity;
import com.studia.backend.entity.EncyclopediaRegistrationEntity;
import com.studia.backend.service.AdminService;
import com.studia.backend.service.BookService;
import com.studia.backend.util.BookConvertObject;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
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

    @DeleteMapping("/data/delete")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity deleteData(){
        adminService.deleteData();
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/book/statistic")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity<Map<String, List<BookConvertObject>>> bookStatistic(@RequestParam String startDate, @RequestParam String endDate){
        return new ResponseEntity<>(adminService.releaseBookStatistic(startDate,endDate),HttpStatus.OK);
    }

    @GetMapping("/registration")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "jwtToken")})
    public ResponseEntity<List<EncyclopediaRegistrationEntity>> getBooksToRegister() {
        return new ResponseEntity<>(adminService.getRegistrationFalse(), HttpStatus.OK);
    }

    @PostMapping("/registration/confirm/{id}")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "jwtToken")})
    public ResponseEntity confirmRegistration(@PathVariable Long id) {
        adminService.confirmRegistration(id);
        return new ResponseEntity( HttpStatus.OK);

    }

    @DeleteMapping("/registration/delete/{id}")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "jwtToken")})
    public ResponseEntity deleteRegistration(@PathVariable Long id) {
        adminService.deleteRegistration(id);
        return new ResponseEntity( HttpStatus.OK);

    }

}
