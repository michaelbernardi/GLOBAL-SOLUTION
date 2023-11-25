package br.com.fiap.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fiap.beans.Predicao;
import br.com.fiap.bo.PredicaoBo;

	
@Path("/predicoes")
public class PredicaoResource {

    PredicaoBo predicaoBO = new PredicaoBo();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response criarPredicao(Predicao variaveis) {
        try {
            predicaoBO.inserirBo(variaveis);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao inserir a predição: " + e.getMessage())
                    .build();
        }
    }
}


