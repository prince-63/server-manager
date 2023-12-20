package com.learn.service.update;

import com.learn.model.Server;
import com.learn.repository.ServerRepository;
import com.learn.response.Response;
import com.learn.response.ResponseProperties;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateServiceImplementation implements UpdateService{

    private final ServerRepository serverRepository;

    @Override
    public ResponseEntity<Response> update(Server newServer) {
        try {
            Server oldServer = serverRepository.findById(newServer.getId()).orElse(null);
            if (oldServer != null) {
                oldServer.setIpAddress(oldServer.getIpAddress().equals(newServer.getIpAddress()) ? oldServer.getIpAddress() : newServer.getIpAddress());
                oldServer.setStatus(oldServer.getStatus().equals(newServer.getStatus()) ? oldServer.getStatus() : newServer.getStatus());
                oldServer.setName(oldServer.getName().equals(newServer.getName()) ? oldServer.getName() : newServer.getName());
                oldServer.setMemory(oldServer.getMemory().equals(newServer.getMemory()) ? oldServer.getMemory() : newServer.getMemory());
                oldServer.setType(oldServer.getType().equals(newServer.getType()) ? oldServer.getType() : newServer.getType());
            }
            serverRepository.save(oldServer);
            return ResponseEntity.ok(ResponseProperties.responseOk(oldServer));
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(ResponseProperties.responseBadRequest(""));
        }
    }
}
