package br.com.fiap.resource;

import br.com.fiap.beans.DadosUsuario;
import br.com.fiap.bo.DadosUsuarioBo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/usuario/{id}")
public class UsuarioResource {

    private DadosUsuarioBo dadosUsuarioBo = new DadosUsuarioBo();

    @GET
    public Response selecionar(@PathParam("id")int id_usuario) {
        try {
            DadosUsuario dadosUsuario = dadosUsuarioBo.obterDadosUsuario(id_usuario);

            if (dadosUsuario != null) {
                return Response.ok(dadosUsuario).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Usuario nao encontrado.").build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao processar a requisição: " + e.getMessage())
                    .build();
        }
    }
}