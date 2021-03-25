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

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.google.gson.Gson;

import Exception.ServiciosException;
import Servicio.QuesosRemote;
import model.Queso;



@RequestScoped
@Path("quesos")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class quesosRest {

	
	@EJB
	private QuesosRemote qremote;
		
	 @GET
	 @Path("saludar")
	 @Produces("text/plain")
	    public String saludar(){
	 return "Hola a quien diga hola con movimiento";
	    }
	 
	 @GET
	 @Path("todos")
	 @Produces({ MediaType.APPLICATION_JSON})
		public List<Queso> getQuesos () {
			List<Queso> listquesos = new ArrayList<>();
		
			try {
				listquesos= qremote.obtenerTodos();
			} catch (ServiciosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return listquesos;
		}
	 
	 @GET
	 @Path("xcateg/{id}")
	 @Produces({ MediaType.APPLICATION_JSON})
		public List<Queso> getQuesoxSubcatego(@PathParam("id") long id) {
			List<Queso> listquesos = new ArrayList<>();
			List<Queso> listque = new ArrayList<>();
		
			try {
				listquesos= qremote.obtenerTodos();
				for (Queso q : listquesos) {
					if(id == q.getSubcatego().getIdSubcateg()) {
						listque.add(q);
					}
				}
					
			} catch (ServiciosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return listque;
		}
	 
	 @POST
	 @Path("crear")
	 @Produces("text/plain")
	 @Consumes({MediaType.APPLICATION_JSON})
	 public Response crearQueso(String dato) {
		 
		 String mensaje;
			Gson gson = new Gson();
			Queso queso = gson.fromJson(dato, Queso.class);
			 try {
				qremote.crearQueso(queso);
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
	 @Produces("text/plain")
	 @Consumes({MediaType.APPLICATION_JSON})
	 public Response updateQueso (String dato) {
		 
		 String mensaje;
			Gson gson = new Gson();
			Queso queso = gson.fromJson(dato, Queso.class);
			 try {
				qremote.modificarQueso(queso);
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
	 public Response borrarMovimiento (String dato) {
		 
		 String mensaje;
			Gson gson = new Gson();
			Queso queso = gson.fromJson(dato, Queso.class);
			System.out.println(queso.getIdQueso());
			try {
				qremote.borrarQueso(queso.getIdQueso());
				mensaje  = "Borrado Ok";
			} catch (ServiciosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				mensaje = "No Borrado";
			}
			return Response.ok(mensaje).build();
		 
	 }
	 	
}
