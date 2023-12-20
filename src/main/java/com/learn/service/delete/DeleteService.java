package com.learn.service.delete;

import com.learn.response.Response;
import org.springframework.http.ResponseEntity;

public interface DeleteService {
    ResponseEntity<Response> delete(Long id);
}
