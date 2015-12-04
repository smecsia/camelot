package ru.yandex.qatools.camelot.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.camelot.api.EventProducer;
import ru.yandex.qatools.camelot.api.annotations.MainInput;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static ru.yandex.qatools.camelot.api.Constants.Headers.UUID;

@Component
@Path("/ping")
@Scope("request")
public class PingResource {

    @MainInput
    EventProducer producer;


    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public Response ping() {
        producer.produce(null, UUID, "ping");
        return Response.ok().build();
    }
}
