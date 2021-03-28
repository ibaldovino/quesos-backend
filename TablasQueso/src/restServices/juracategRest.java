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
import Servicio.JuracategsRemote;
import model.Juracateg;

@RequestScoped
@Path("juracateg")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class juracategRest {

	
	@EJB
	private JuracategsRemote remote;
	
	 @GET
	 @Path("saludar")
	 @Produces("text/plain")
	    public String saludar(){
	 return "Hola a quien diga hola con movimiento";
	    }
	 
	 @GET
	 @Path("todas")
	 @Produces({MediaType.APPLICATION_JSON})
	public String getJuracateg () {
			
		 List<Juracateg> list = new ArrayList<>();
		
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
	 public Response crearJuracateg(String dato) {
		 
		 String mensaje;
			Gson gson = new Gson();
			Juracateg obj = gson.fromJson(dato, Juracateg.class);
			 try {
				 System.out.println(dato);
				remote.crearJuracateg(obj);
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
	 public Response updateJuracateg (String dato) {
		 
		 String mensaje;
			Gson gson = new Gson();
			Juracateg obj = gson.fromJson(dato, Juracateg.class);
			 try {
				remote.modificarJuracateg(obj);
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
	 public Response borrarJuracateg (String dato) {
		 
		 String mensaje;
			Gson gson = new Gson();
			Juracateg obj = gson.fromJson(dato, Juracateg.class);
			//System.out.println(obj.getIdSubcateg());
			try {
				remote.borrarJuracateg(obj.getIdJurcat());
				mensaje  = "Borrado Ok";
			} catch (ServiciosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				mensaje = "No Borrado";
			}
			return Response.ok(mensaje).build();
		 
	 }
}
