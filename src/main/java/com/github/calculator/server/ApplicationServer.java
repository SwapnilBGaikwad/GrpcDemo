package com.github.calculator.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.util.logging.Logger;

public class ApplicationServer {
    private static final Logger logger = Logger.getLogger(ApplicationServer.class.getName());
    private static final int PORT = 50051;
    private Server server;

    public void start() throws Exception {
        server = ServerBuilder
                .forPort(PORT)
                .addService(new CalculatorController())
                .build().start();
        logger.info("Server started, listening on " + PORT);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            server.shutdown();
            System.err.println("*** server shut down");
        }));
        server.awaitTermination();
    }
}
