package com.example.resttesting;

import com.example.resttesting.model.Users;
import com.example.resttesting.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HomeController {
    private final UserRepository userRepository;

    @Operation(summary = "All users",
                description = "This is to fetch all the users", tags = "Get")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "fetched all users",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "No User found",
                    content = @Content)
    })
    @GetMapping("/api")
    public ResponseEntity<?> home(){
        return ResponseEntity.ok().body(userRepository.findAll());
    }

    @PostMapping("/api")
    public ResponseEntity<?> add(@RequestBody Users users){
        return new ResponseEntity<>(userRepository.save(users), HttpStatus.CREATED);
    }

    @PutMapping("/api")
    @ResponseStatus(HttpStatus.OK)
    public Users update(@RequestBody Users users){
        Users users1 = userRepository.findByUsername(users.getUsername());
        users1.setFirstName(users.getFirstName());
        return userRepository.save(users1);
    }

    @DeleteMapping("/api/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
