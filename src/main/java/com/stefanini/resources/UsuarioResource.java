package com.stefanini.resources;

import com.stefanini.dto.UsuarioDTO;
import com.stefanini.model.Usuario;
import com.stefanini.repository.UsuarioRepository;
import com.stefanini.service.UsuarioService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.List;

@Path("/usuarios")
public class UsuarioResource {

    @Inject
    UsuarioService usuarioService;

    @GET
    public Response listarUsuarios() {
        List<UsuarioDTO> listaUsuarios = usuarioService.listarUsuarios();
        return Response.status(Response.Status.OK).entity(listaUsuarios).build();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        UsuarioDTO usuarioDTO = usuarioService.buscarPorId(id);
        return Response.status(Response.Status.OK).entity(usuarioDTO).build();
    }

    @POST
    public Response adicionarUsuario(UsuarioDTO usuarioDTO){
        return Response.status(Response.Status.CREATED).entity(usuarioService.adicionarUsuario(usuarioDTO)).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizarUsuario(@PathParam("id") Long id, UsuarioDTO usuarioDTO){
        return Response.status(Response.Status.OK).entity(usuarioService.atualizarUsuario(id, usuarioDTO)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletarUsuario(@PathParam("id") Long id){
        usuarioService.deletarUsuario(id);
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/aniversariantes")
    public Response buscarAniversariantes(){
        int mes = LocalDate.now().getMonthValue();
        return Response.status(Response.Status.OK).entity(usuarioService.buscarAniversariantes(mes)).build();
    }

    @GET
    @Path("/aniversariantes/{mes}")
    public Response buscarAniversariantesParam(@PathParam("mes") int mes){
        return Response.status(Response.Status.OK).entity(usuarioService.buscarAniversariantes(mes)).build();
    }

    @GET
    @Path("/inicial/{letra}")
    public Response buscarPrimeiraLetra(@PathParam("letra") String letra){
        return Response.status(Response.Status.OK).entity(usuarioService.buscarPrimeiraLetra(letra)).build();
    }

    @GET
    @Path("/email")
    public Response listarProvedores(){
        return Response.status(Response.Status.OK).entity(usuarioService.listarProvedores()).build();
    }

}
