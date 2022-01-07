package org.acme;


import javax.ws.rs.client.Client;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class HelloClient {
   private final Client client = ClientBuilder.newClient();
   private final WebTarget target = client.target("http://localhost:8080/");

   public String getHello() {
       return target.path("hello").request().accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
   }

    public Person getPerson() {
        return target.path("hello").path("person").request().accept(MediaType.APPLICATION_JSON_TYPE).get(Person.class);
    }



}
