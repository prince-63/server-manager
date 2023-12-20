package com.learn.controller.get;

import com.learn.response.Response;
import com.learn.service.get.GetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/server")
public class GetController {
    private final GetService getService;

    @GetMapping("/list")
    public ResponseEntity<Response> serverList() {
        return getService.list(10);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Response> getServer(@PathVariable Long id) {
        return getService.get(id);
    }
}
