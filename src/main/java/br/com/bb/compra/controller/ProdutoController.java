package br.com.bb.compra.controller;

import br.com.bb.compra.model.Produto;
import br.com.bb.compra.service.ProdutoService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.arjuna.ats.internal.arjuna.objectstore.jdbc.drivers.postgres_driver;

@Path("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GET
    @Path("/{id}")
    public Response getId(@PathParam("id") Long id) {
        return Response.ok(produtoService.buscaPorId(id)).build();
    }

    @GET
    @Path("/todos")
    public List<Produto> listaTodosProdutos() {
        return produtoService.buscarTodosProdutos();
    }

    @GET
    public Response listar(@QueryParam("filtro") @DefaultValue("") String filtro,
                            @QueryParam("page") @DefaultValue("0") Integer page,
                            @QueryParam("size") @DefaultValue("20") Integer size) {
        return Response.ok(produtoService.listar(filtro, page, size)).build();
    }

    @POST
    public Response salvar(@Valid Produto produto) {
        return Response.ok(produtoService.salvar(produto)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteId(@PathParam("id") Long id) {
        return Response.ok(produtoService.deletarPorId(id)).build();
    }

}
