package com.github.calculator.server;

import com.github.calculator.CalculatorGrpc;
import com.github.calculator.Request;
import com.github.calculator.Response;
import io.grpc.stub.StreamObserver;

public class CalculatorController extends CalculatorGrpc.CalculatorImplBase {
    @Override
    public void sum(Request request, StreamObserver<Response> responseObserver) {
        int sum = request.getA() + request.getB();
        Response response = Response.newBuilder().setResult(sum).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void subtract(Request request, StreamObserver<Response> responseObserver) {
        super.subtract(request, responseObserver);
    }
}
