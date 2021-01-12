package ais.service.discovery.java;

public interface IFunctionAdapter {
    <T, R> Response<T> request(Service service, Request<R> request);
}
