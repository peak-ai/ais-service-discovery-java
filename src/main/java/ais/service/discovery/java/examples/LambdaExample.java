package ais.service.discovery.java.examples;

import ais.service.discovery.java.*;
import ais.service.discovery.java.aws.AWSFactory;
import com.fasterxml.jackson.databind.JsonNode;

public class LambdaExample {
    static class MyClass {
        public String name;
        public String tenant;
        public boolean dataLake = true;
        public boolean sessionCreds = true;
        public String timezone;
        public String tenantType;
        public JsonNode envs;

        public MyClass(String name, String tenant, boolean dataLake) {
            this.name = name;
            this.tenant = tenant;
            this.dataLake = dataLake;
        }
    }

    public static void main(String[] args) {
        try {
            IDiscovery discovery = AWSFactory.build("eu-west-1");
            Request<MyClass> request = new Request<>(new MyClass("My class", "tenantName", true));
            MyClass response = discovery.request("ais-latest.tenant-manager->fetch-tenant-metadata", request).getResult(MyClass.class);
            System.out.println("Response-envs: " + response.envs);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
