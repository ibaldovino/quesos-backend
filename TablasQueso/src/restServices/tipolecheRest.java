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
import Servicio.TipolechesRemote;
import model.Tipoleche;


@RequestScoped
@Path("tipoleche")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class tipolecheRest {
	
	@EJB
	private TipolechesRemote remote;
	
	 @GET
	 @Path("saludar")
	 @Produces("text/plain")
	    public String saludar(){
	 return "Hola a quien diga hola con movimiento";
	    }
	 
	 @GET
	 @Path("todas")
	 @Produces({MediaType.APPLICATION_JSON})
	public String getTipoleche () {
			
		 List<Tipoleche> list = new ArrayList<>();
		
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
	 public Response crearTipoleche(String dato) {
		 
		 String mensaje;
			Gson gson = new Gson();
			Tipoleche obj = gson.fromJson(dato, Tipoleche.class);
			 try {
				 System.out.println(dato);
				remote.crearTipoleche(obj);
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
	 public Response updateTipoleche (String dato) {
		 
		 String mensaje;
			Gson gson = new Gson();
			Tipoleche obj = gson.fromJson(dato, Tipoleche.class);
			 try {
				remote.modificarTipoleche(obj);
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
	 public Response borrarTipoleche (String dato) {
		 
		 String mensaje;
			Gson gson = new Gson();
			Tipoleche obj = gson.fromJson(dato, Tipoleche.class);
			//System.out.println(obj.getIdSubcateg());
			try {
				remote.borrarTipoleche(obj.getIdTiplec());
				mensaje  = "Borrado Ok";
			} catch (ServiciosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				mensaje = "No Borrado";
			}
			return Response.ok(mensaje).build();
		 
	 }

}
