package br.com.jaa.api.features;

import br.com.jaa.api.features.user.dtos.UserRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping(value = "/")
public class IndexController {

    @GetMapping(value = "")
    public ResponseEntity<Object> index() {
        var body = Collections.singletonMap("success", true);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @PostMapping(value = "/sign-in")
    public ResponseEntity<Object> signIn(@Valid @RequestBody UserRequest user) {
        var body = Collections.singletonMap("signIn", user);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @PostMapping(value = "/sign-up")
    public ResponseEntity<Object> signUp(@Valid @RequestBody UserRequest user) {
        var body = Collections.singletonMap("signUp", user);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

}
