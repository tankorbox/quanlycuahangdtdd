package services;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bean.DienThoai;
import model.DienThoaiModel;

@Path("/dienthoai")
public class DienThoaiAPI {
	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllDienThoai() {
		DienThoaiModel dienThoaiModel = new DienThoaiModel();
		List<DienThoai> listDienThoai = dienThoaiModel.getAll();
		return Response.ok(listDienThoai).build();
	}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDienThoaiById(@PathParam("id") int id) {
		DienThoaiModel dienThoaiModel = new DienThoaiModel();
		DienThoai dt = dienThoaiModel.getDienThoaiById(id);
		return Response.ok(dt).build();
	}
}
