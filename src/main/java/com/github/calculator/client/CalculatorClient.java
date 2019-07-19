package com.github.calculator.client;

import com.github.calculator.CalculatorGrpc;
import com.github.calculator.Request;
import com.github.calculator.Response;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class CalculatorClient {
    private static final Logger logger = Logger.getLogger(CalculatorClient.class.getName());
    private final ManagedChannel channel;
    private final CalculatorGrpc.CalculatorBlockingStub calculatorBlockingStub;

    public CalculatorClient(String host, int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.channel = channel;
        calculatorBlockingStub = CalculatorGrpc.newBlockingStub(channel);
    }


    public void execute() {
        Request request = Request.newBuilder().setA(1).setB(4).build();
        Response response = calculatorBlockingStub.sum(request);
        logger.info("Sum of 1 and 4 is " + response.getResult());
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}
