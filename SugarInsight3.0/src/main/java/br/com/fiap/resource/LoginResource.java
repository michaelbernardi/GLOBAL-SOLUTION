package br.com.fiap.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import br.com.fiap.beans.DadosUsuario;
import br.com.fiap.beans.Login;
import br.com.fiap.bo.LoginBo;

@Path("/login")
public class LoginResource {

    private LoginBo loginBo = new LoginBo();

    @GET
    public Response verificarLogin(
            @QueryParam("cpf") String cpf,
            @QueryParam("senha") String senha) {
        
        try {
            Login login = new Login(cpf, senha);
            DadosUsuario dadosUsuario = loginBo.realizarLoginComInformacoes(login);

            if (dadosUsuario != null) {
                // Login válido, redirecionar para o endpoint do usuário
                int idUsuario = dadosUsuario.getId_usuario();
                UriBuilder uriBuilder = UriBuilder.fromPath("/usuario/{id}").resolveTemplate("id", idUsuario);
                return Response.seeOther(uriBuilder.build()).build();
            } else {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity("Usuário não autorizado. Verifique as credenciais.")
                        .build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao processar a requisição: " + e.getMessage())
                    .build();
        }
    }
}
