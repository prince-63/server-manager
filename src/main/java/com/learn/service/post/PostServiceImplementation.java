package com.learn.service.post;

import com.learn.model.Server;
import com.learn.repository.ServerRepository;
import com.learn.response.Response;
import com.learn.response.ResponseProperties;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.InetAddress;
import java.util.Random;

import static com.learn.enumeration.Status.SERVER_DOWN;
import static com.learn.enumeration.Status.SERVER_UP;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImplementation implements PostService{

    private final ServerRepository serverRepository;

    @Override
    public ResponseEntity<Response> create(Server server) {
        try {
            server.setImageURL(setServerImageUrl());
            serverRepository.save(server);
            return ResponseEntity.ok(ResponseProperties.responseCreated(server));
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(ResponseProperties.responseBadRequest(null));
        }
    }

    private String setServerImageUrl() {
        String[] imageNames = { "server1.png", "server2.png", "server3.png", "server4.png"};
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image/" + imageNames[new Random().nextInt(4)]).toUriString();
    }

    @Override
    public ResponseEntity<Response> ping(String ipAddress) {
        try {
            Server server = serverRepository.findByIpAddress(ipAddress);
            InetAddress address = InetAddress.getByName(ipAddress);
            server.setStatus(address.isReachable(1000) ? SERVER_UP : SERVER_DOWN);
            serverRepository.save(server);
            return ResponseEntity.ok(ResponseProperties.responseCreated(server));
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(ResponseProperties.responseBadRequest(""));
        }
    }
}
