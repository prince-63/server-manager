package com.learn.service.get;

import com.learn.response.Response;
import org.springframework.http.ResponseEntity;

public interface GetService {
    ResponseEntity<Response> list(int limit);
    ResponseEntity<Response> get(Long id);
}
