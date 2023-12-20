package com.learn.controller.post;

import com.learn.model.Server;
import com.learn.response.Response;
import com.learn.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/server")
public class PostController {
    private final PostService postService;

    @PostMapping("/create")
    public ResponseEntity<Response> create(@RequestBody Server server) {
        return postService.create(server);
    }
}
