package restServices;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import Exception.ServiciosException;
import Servicio.TecnologiasRemote;
import model.Tecnologia;

@RequestScoped
@Path("tecnologias")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class tecnologiasRest {
	
	@EJB
	private TecnologiasRemote remote;
	
	 @GET
	 @Path("saludar")
	 @Produces("text/plain")
	    public String saludar(){
	 return "Hola a quien diga hola con movimiento";
	    }
	 
	 @GET
	 @Path("todas")
	 @Produces({MediaType.APPLICATION_JSON})
	public String getTecnologia () {
			
		 List<Tecnologia> list = new ArrayList<>();
		
			try {
				list= remote.obtenerTodas();
			} catch (ServiciosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Gson gson = new Gson();
			String json = gson.toJson(list);
			System.out.println(list);
			
		return json;
		}
	 
	 @POST
	 @Path("crear")
	 @Produces("text/plain")
	 @Consumes({MediaType.APPLICATION_JSON})
	 public Response crearTecnologia(String dato) {
		 
		 String mensaje;
			Gson gson = new Gson();
			Tecnologia obj = gson.fromJson(dato, Tecnologia.class);
			 try {
				 System.out.println(dato);
				remote.crearTecnologia(obj);
				mensaje =  "Creado Ok";
			} catch (ServiciosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				mensaje =  "No Creado";
			}
			return Response.ok(mensaje).build();
		 
	 }
	 
	 @PUT
	 @Path("update")
	 @Consumes({MediaType.APPLICATION_JSON})
	 public Response updateTecnologia (String dato) {
		 
		 String mensaje;
			Gson gson = new Gson();
			Tecnologia obj = gson.fromJson(dato, Tecnologia.class);
			 try {
				remote.modificarTecnologia(obj);
				mensaje  = "Actualizado Ok";
			} catch (ServiciosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				mensaje = "No Actualizado";
			}
			return Response.ok(mensaje).build();
		 
	 }
	 
	 @DELETE
	 @Path("borrar")
	 @Produces("text/plain")
	 @Consumes({MediaType.APPLICATION_JSON})
	 public Response borrarTecnologia (String dato) {
		 
		 String mensaje;
			Gson gson = new Gson();
			Tecnologia obj = gson.fromJson(dato, Tecnologia.class);
			//System.out.println(obj.getIdSubcateg());
			try {
				remote.borrarTecnologia(obj.getIdTecno());
				mensaje  = "Borrado Ok";
			} catch (ServiciosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				mensaje = "No Borrado";
			}
			return Response.ok(mensaje).build();
		 
	 }

}
