package com.learn.service.delete;

import com.learn.response.Response;
import com.learn.response.ResponseProperties;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.learn.repository.ServerRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteServiceImplementation implements DeleteService {

    private final ServerRepository serverRepository;

    @Override
    public ResponseEntity<Response> delete(Long id) {
        try {
            if (serverRepository.existsById(id)) {
                serverRepository.deleteById(id);
                return ResponseEntity.ok(ResponseProperties.responseOk(""));
            }
            return ResponseEntity.ok(ResponseProperties.responseNotFound(""));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(ResponseProperties.responseBadRequest(""));
        }
    }
}
