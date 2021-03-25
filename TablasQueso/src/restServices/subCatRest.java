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
import Servicio.SubCategoriaRemote;
import model.Subcatego;



@RequestScoped
@Path("subcat")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class subCatRest {

	@EJB
	private SubCategoriaRemote scremote;
		
	 @GET
	 @Path("saludar")
	 @Produces("text/plain")
	    public String saludar(){
	 return "Hola a quien diga hola con movimiento";
	    }
	 
	 @GET
	 @Path("todas")
	 @Produces({MediaType.APPLICATION_JSON})
	public String getSubcatego () {
			List<Subcatego> listsubcat = new ArrayList<>();
		
			try {
				listsubcat= scremote.obtenerTodos();
			} catch (ServiciosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Gson gson = new Gson();
			String json = gson.toJson(listsubcat);
			System.out.println(listsubcat);
			
		return json;
		}
	 
	 @POST
	 @Path("crearsc")
	 @Produces("text/plain")
	 @Consumes({MediaType.APPLICATION_JSON})
	 public Response crearSubcat(String dato) {
		 
		 String mensaje;
			Gson gson = new Gson();
			Subcatego subcat = gson.fromJson(dato, Subcatego.class);
			 try {
				 System.out.println(dato);
				scremote.crearSubCategoria(subcat);
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
	 public Response updateSubCategoria (String dato) {
		 
		 String mensaje;
			Gson gson = new Gson();
			Subcatego sc = gson.fromJson(dato, Subcatego.class);
			 try {
				scremote.modificarsubcatego(sc);
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
	 public Response borrarSubCategoria (String dato) {
		 
		 String mensaje;
			Gson gson = new Gson();
			Subcatego sc = gson.fromJson(dato, Subcatego.class);
			System.out.println(sc.getIdSubcateg());
			try {
				scremote.borrarsubcatego(sc.getIdSubcateg());
				mensaje  = "Borrado Ok";
			} catch (ServiciosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				mensaje = "No Borrado";
			}
			return Response.ok(mensaje).build();
		 
	 }
	 
	
	
	
}
