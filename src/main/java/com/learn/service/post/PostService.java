package com.learn.service.post;

import com.learn.model.Server;
import com.learn.response.Response;
import org.springframework.http.ResponseEntity;

public interface PostService {
    ResponseEntity<Response> create(Server server);
    ResponseEntity<Response> ping(String ipAddress);
}
