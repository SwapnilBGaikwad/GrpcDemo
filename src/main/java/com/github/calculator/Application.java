package com.github.calculator;

import com.github.calculator.client.CalculatorClient;
import com.github.calculator.server.ApplicationServer;

public class Application {
    public static void main(String[] args) throws Exception {
        final ApplicationServer server = new ApplicationServer();
        server.start();
        CalculatorClient client = new CalculatorClient("localhost", 50051);
        client.execute();
        client.execute();
        client.shutdown();
        server.stop();
    }
}
