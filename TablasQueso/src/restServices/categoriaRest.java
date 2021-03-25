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
import Servicio.CategoriasRemote;
import model.Categoria;


@RequestScoped
@Path("categoria")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })

public class categoriaRest {
	
	@EJB
	private CategoriasRemote remote;
	
	@GET
	 @Path("saludar")
	 @Produces("text/plain")
	    public String saludar(){
	 return "Hola a quien diga hola con movimiento";
	    }
	 
	 @GET
	 @Path("todas")
	 @Produces({MediaType.APPLICATION_JSON})
	public String getCategoria () {
			
		 List<Categoria> list = new ArrayList<>();
		
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
	 public Response crearCategoria(String dato) {
		 
		 String mensaje;
			Gson gson = new Gson();
			Categoria obj = gson.fromJson(dato, Categoria.class);
			 try {
				 System.out.println(dato);
				remote.crearCategoria(obj);
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
	 public Response updateCategoria (String dato) {
		 
		 String mensaje;
			Gson gson = new Gson();
			Categoria obj = gson.fromJson(dato, Categoria.class);
			 try {
				remote.modificarCategoria(obj);
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
	 public Response borrarCategoria (String dato) {
		 
		 String mensaje;
			Gson gson = new Gson();
			Categoria obj = gson.fromJson(dato, Categoria.class);
			//System.out.println(obj.getIdSubcateg());
			try {
				remote.borrarCategoria(obj.getIdCateg());
				mensaje  = "Borrado Ok";
			} catch (ServiciosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				mensaje = "No Borrado";
			}
			return Response.ok(mensaje).build();
		 
	 }

}
