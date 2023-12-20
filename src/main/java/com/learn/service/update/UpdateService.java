package com.learn.service.update;

import com.learn.model.Server;
import com.learn.response.Response;
import org.springframework.http.ResponseEntity;

public interface UpdateService {
    ResponseEntity<Response> update(Server server);
}
