package com.quarkus;


import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @GET
    public List<Produto> buscarTodosProdutos() {
        return Produto.listAll();
    }

    @Transactional
    @POST
    public void buscarTodosProdutos(CadastrarProdutoDTO dto) {
        Produto p = new Produto();
        p.nome = dto.nome;
        p.valor = dto.valor;
        p.persist();
    }

    @Transactional
    @PUT
    @Path("{id}")
    public void buscarTodosProdutos(@PathParam("id") Long id, CadastrarProdutoDTO dto) {
        Optional<Produto> produtoOp = Produto.findByIdOptional(id);
        if (produtoOp.isPresent()) {
            Produto produto = produtoOp.get();
            produto.nome = dto.nome;
            produto.valor = dto.valor;
            produto.persist();
        } else {
            throw new NotFoundException();
        }
    }

    @Transactional
    @DELETE
    @Path("{id}")
    public void buscarTodosProdutos(@PathParam("id") Long id) {
        Optional<Produto> produtoOp = Produto.findByIdOptional(id);
        produtoOp.ifPresentOrElse(Produto::delete, () -> {
            throw new NotFoundException();
        });
    }


}
