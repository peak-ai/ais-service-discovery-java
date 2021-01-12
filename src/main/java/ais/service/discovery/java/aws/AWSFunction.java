package ais.service.discovery.java.aws;

import ais.service.discovery.java.IFunctionAdapter;
import ais.service.discovery.java.Request;
import ais.service.discovery.java.Response;
import ais.service.discovery.java.Service;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;

public class AWSFunction implements IFunctionAdapter {
    public final AWSLambda client;

    public AWSFunction(AWSLambda client) {
        this.client = client;
    }

    @Override
    public Response request(Service service, Request request) {
        InvokeRequest req = new InvokeRequest();
        req.withFunctionName(service.getArn());
        req.withPayload(request.getBody());
        InvokeResult result = this.client.invoke(req);
        return new Response(result.getPayload(), result.getStatusCode());
    }
}
