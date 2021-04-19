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
import Servicio.UsuariosRemote;
import model.Usuario;


@RequestScoped
@Path("usuario")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class usuarioRest {
	
	@EJB
	private UsuariosRemote usuremote;
		
	 @GET
	 @Path("saludar")
	 @Produces("text/plain")
	    public String saludar(){
	 return "Hola a quien diga hola con usuario";
	    }
	 
	 @GET
	 @Path("todos")
	 @Produces({MediaType.APPLICATION_JSON})
	public String getUsuarios () {
			List<Usuario> listsusu = new ArrayList<>();
		
			try {
				listsusu= usuremote.obtenerTodos();
			} catch (ServiciosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Gson gson = new Gson();
			String json = gson.toJson(listsusu);
			System.out.println(listsusu);
			
		return json;
		}
	 
	 @POST
	 @Path("crearusu")
	 @Produces("text/plain")
	 @Consumes({MediaType.APPLICATION_JSON})
	 public Response crearUsuario(String dato) {
		 
		 String mensaje;
			Gson gson = new Gson();
			Usuario usuario = gson.fromJson(dato, Usuario.class);
			 try {
				 System.out.println(dato);
				usuremote.crearUsuario(usuario);
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
	 public Response updateUsuario (String dato) {
		 
		 String mensaje;
			Gson gson = new Gson();
			Usuario usu = gson.fromJson(dato, Usuario.class);
			 try {
				usuremote.modificarusuario(usu);
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
	 public Response borrarUsuario (String dato) {
		 
		 String mensaje;
			Gson gson = new Gson();
			Usuario usu = gson.fromJson(dato, Usuario.class);
			System.out.println(usu.getIdUsuario());
			try {
				usuremote.borrarUsuario(usu.getIdUsuario());
				mensaje  = "Borrado Ok";
			} catch (ServiciosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				mensaje = "No Borrado";
			}
			return Response.ok(mensaje).build();
		 
	 }
	 
	 @GET
	 @Path("usuact/{nomusu}/{pass}")
	 @Produces({MediaType.APPLICATION_JSON})
	 @Consumes({MediaType.APPLICATION_JSON})
	 public String checkUsuario (@PathParam ("nomusu") String nomusu,@PathParam("pass")String pass) {
		 
		 List<Usuario> listsusu = new ArrayList<>();
		 String usuario = null;
			Gson gson = new Gson();
			String nombreusu = gson.fromJson(nomusu, String.class);
			String passusu = gson.fromJson(pass, String.class);
			System.out.println(nombreusu);
			System.out.println(passusu);
			try {
				listsusu = usuremote.obtenerTodos();
				
				for(Usuario u : listsusu) {
					if(u.getNomUsuario().equals(nombreusu)&& u.getPwdUsuario().equals(passusu)) {
						usuario = gson.toJson(u);
						System.out.println(usuario);
					}
			
				}
				
			} catch (ServiciosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//usuario = "Error de Servicio Usuario";
			}
			return usuario;
		 
	 }
	 

}
