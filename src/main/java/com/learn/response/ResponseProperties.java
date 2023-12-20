package com.learn.response;

import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.*;

public class ResponseProperties {
    public static <T> Response responseOk(T data) {
        return Response.builder()
                .timeStamp(now())
                .message("every thing good.")
                .data(Map.of("servers", data))
                .status(OK)
                .statusCode(OK.value())
                .build();
    }

    public static <T> Response responseCreated(T data) {
        return Response.builder()
                .timeStamp(now())
                .message("created new server.")
                .data(Map.of("servers", data))
                .status(CREATED)
                .statusCode(CREATED.value())
                .build();
    }

    public static <T> Response responseNotFound(T data) {
        return Response.builder()
                .timeStamp(now())
                .message("something went wrong.")
                .data(Map.of("servers", data))
                .status(NOT_FOUND)
                .statusCode(NOT_FOUND.value())
                .build();
    }

    public static <T> Response responseBadRequest(T data) {
        return Response.builder()
                .timeStamp(now())
                .message("please check you response.")
                .data(Map.of("servers", data))
                .status(BAD_REQUEST)
                .statusCode(BAD_REQUEST.value())
                .build();
    }

    public static <T> Response responseBadGateway(T data) {
        return Response.builder()
                .timeStamp(now())
                .message("something wrong in api.")
                .data(Map.of("servers", data))
                .status(BAD_GATEWAY)
                .statusCode(BAD_GATEWAY.value())
                .build();
    }
}
