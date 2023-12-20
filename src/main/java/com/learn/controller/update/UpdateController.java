package com.learn.controller.update;

import com.learn.model.Server;
import com.learn.response.Response;
import com.learn.service.update.UpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/server")
public class UpdateController {
    private final UpdateService updateService;

    @PutMapping("/update")
    public ResponseEntity<Response> update(@RequestBody Server server) {
        return updateService.update(server);
    }
}
