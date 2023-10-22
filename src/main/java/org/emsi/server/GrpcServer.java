package org.emsi.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.emsi.service.BankGrpcService;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(5555)
                .addService(new BankGrpcService())
                .build();
        server.start();
        server.awaitTermination();
    }
}
