package com.github.calculator;

import com.github.calculator.server.ApplicationServer;

public class Application {
    public static void main(String[] args) throws Exception {
        final ApplicationServer server = new ApplicationServer();
        server.start();
    }
}
