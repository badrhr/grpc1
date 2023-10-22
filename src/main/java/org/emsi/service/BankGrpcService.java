package org.emsi.service;

import io.grpc.stub.StreamObserver;
import org.emsi.stubs.Bank;
import org.emsi.stubs.BankServiceGrpc;

public class BankGrpcService extends BankServiceGrpc.BankServiceImplBase {

    @Override
    public void convert(Bank.ConvertCurrencyRequest request, StreamObserver<Bank.ConvertCurrencyResponse> responseObserver) {
        String currencyFrom  = request.getCurrencyFrom();
        String currencyTo  = request.getCurrencyTo();
        double amount  = request.getAmount();
        Bank.ConvertCurrencyResponse response = Bank.ConvertCurrencyResponse.newBuilder()
                .setCurrencyFrom(currencyFrom)
                .setCurrencyTo(currencyTo)
                .setAmount(amount)
                .setResult(amount * 12.14)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getCurrencyStream(Bank.ConvertCurrencyRequest request, StreamObserver<Bank.ConvertCurrencyResponse> responseObserver) {
        super.getCurrencyStream(request, responseObserver);
    }

    @Override
    public StreamObserver<Bank.ConvertCurrencyRequest> performStream(StreamObserver<Bank.ConvertCurrencyResponse> responseObserver) {
        return super.performStream(responseObserver);
    }

    @Override
    public StreamObserver<Bank.ConvertCurrencyRequest> fullCurrencyStream(StreamObserver<Bank.ConvertCurrencyResponse> responseObserver) {
        return super.fullCurrencyStream(responseObserver);
    }
}
