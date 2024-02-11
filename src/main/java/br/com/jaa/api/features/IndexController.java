package br.com.jaa.api.features;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Object> signIn() {
        var body = Collections.singletonMap("signIn", true);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @PostMapping(value = "/sign-up")
    public ResponseEntity<Object> signUp() {
        var body = Collections.singletonMap("signUp", true);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

}
