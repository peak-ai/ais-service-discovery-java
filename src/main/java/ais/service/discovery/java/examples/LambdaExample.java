package ais.service.discovery.java.examples;

import ais.service.discovery.java.*;
import ais.service.discovery.java.aws.AWSFactory;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LambdaExample {
    static class MyClass {
        public String name;

        public MyClass(@JsonProperty("name") String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    public static void main(String[] args) {
        try {
            IDiscovery discovery = AWSFactory.build("eu-west-1");
            Request<MyClass> request = new Request<>(new MyClass("Test Person"));
            Response<MyClass> response = discovery.request("ais-service.tenant-manager->fetch-tenant-metadata", request);

            System.out.println(response.getResult(MyClass.class).getName());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
