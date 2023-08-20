package com.paymentic;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Path("/payments")
public class PSPResource {

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public PaymentResult payments(PaymentRequest request) {
    var value = BigDecimal.valueOf(Double.valueOf(request.getValue()));
    if (BigDecimal.valueOf(400).compareTo(value) > 0 ){
      return new PaymentResult(UUID.randomUUID().toString(),"declined", LocalDateTime.now());
    }
    return new PaymentResult(UUID.randomUUID().toString(),"approved", LocalDateTime.now());
  }
}
