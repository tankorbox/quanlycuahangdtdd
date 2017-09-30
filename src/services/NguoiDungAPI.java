package services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bean.NguoiDung;
import model.NguoiDungModel;

@Path("/admin/users")
public class NguoiDungAPI {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getall")
	public Response getAll() {
		NguoiDungModel nguoiDungModel = new NguoiDungModel();
		List<NguoiDung> listND = nguoiDungModel.getAll();
		return Response.ok(listND).build();
	}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNguoiDungById(@PathParam("id") int id) {
		NguoiDungModel nguoiDungModel = new NguoiDungModel();
		NguoiDung nd = nguoiDungModel.getNguoiDungById(id);
		return Response.ok(nd).build();
	}
}
