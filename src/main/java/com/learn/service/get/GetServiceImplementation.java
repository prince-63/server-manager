package com.learn.service.get;

import com.learn.response.Response;
import com.learn.model.Server;
import com.learn.repository.ServerRepository;
import com.learn.response.ResponseProperties;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GetServiceImplementation implements GetService{

    private final ServerRepository serverRepository;

    @Override
    public ResponseEntity<Response> list(int limit) {
        try {
            List<Server> serverList = serverRepository.findAll(PageRequest.of(0, limit)).toList();
            return ResponseEntity.ok(ResponseProperties.responseOk(serverList));
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(ResponseProperties.responseNotFound(""));
        }
    }

    @Override
    public ResponseEntity<Response> get(Long id) {
        try {
            Server server = serverRepository.findById(id).get();
            return ResponseEntity.ok(ResponseProperties.responseOk(server));
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(ResponseProperties.responseNotFound(""));
        }
    }
}
