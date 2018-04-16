/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author janto
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of rest.GenericResource
     * @return an instance of java.lang.String
     */
    
    //poner plain text
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getXml() {
        //usar el plugin restlet le pasamos la ruta chrome-extension://aejoelaoggembcahagimdiliamlcdmfm/restlet_client.html
      
       return "loquesea";
    }
    @GET
    @Path("Suma")
    @Produces(MediaType.TEXT_PLAIN)
    public int getSuma(@QueryParam("valorA") int a, @QueryParam("valorB")int b) {
        //localhost:8080/EjemploRest/webresources/generic/Suma?valorA=1&valorB=1
      int suma;
      suma = a+b;
       return suma;
    }
    //devolver xml introduzco parametros y deberia mostrar xmlç
    @GET
    @Path("CrearContacto")
    @Produces(MediaType.APPLICATION_XML)
    public Persona getPersona() {
      Persona p = new Persona();
      p.setName("pep");
      p.setEmail("pepe@gmail.com");
      p.setTelephone(6253474);
      return p;
    }
    
    @POST
    @Path("AlmacenarPersona")
    @Produces(MediaType.APPLICATION_XML)
    //Poner post --> application/xml --> http://localhost:8080/EjemploRest/webresources/generic/AlmacenarPersona
    //marshall
    public ArrayList<Persona> recuperarPersona() {
        Persona p = new Persona();
        ArrayList<Persona> a = new ArrayList<Persona>();
        p = this.getPersona();
        a.add(p);
     return a;

    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
