package com.good.food.driver.web;

import java.net.URI;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.good.food.adapter.controller.PedidoController;
import com.good.food.application.presenter.pedido.PedidoRequest;
import com.good.food.application.presenter.pedido.PedidoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("pedido")
@Api(value = "/pedido", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PedidoWebController {

    private final PedidoController pedidoController;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 201, message = "Created")
    })
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "/regredir-status/{id}")
    @Operation(
            summary = "Regredir status do pedido",
            description = "Regredir o status de um pedido",
            parameters = @io.swagger.v3.oas.annotations.Parameter(
                    name = "id",
                    description = "ID do pedido",
                    required = true,
                    example = "123e4567-e89b-12d3-a456-426614174000"
            )
    )
    public ResponseEntity<PedidoResponse> regredirStatus(@PathVariable String id) {
        PedidoResponse pedidoResponse = pedidoController.regredirStatus(id);
        return ResponseEntity.created(URI.create("/" + pedidoResponse.getId())).body(pedidoResponse);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 201, message = "Created")
    })
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "/avancar-status/{id}")
    @Operation(
            summary = "Avançar status do pedido",
            description = "Avançar o status de um pedido",
            parameters = @io.swagger.v3.oas.annotations.Parameter(
                    name = "id",
                    description = "ID do pedido",
                    required = true,
                    example = "123e4567-e89b-12d3-a456-426614174000"
            )
    )
    public ResponseEntity<PedidoResponse> avancarStatus(@PathVariable String id) {
        PedidoResponse pedidoResponse = pedidoController.avancarStatus(id);
        return ResponseEntity.created(URI.create("/" + pedidoResponse.getId())).body(pedidoResponse);
    }
    
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 201, message = "Created")
    })
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping()
    @Operation(
            summary = "Listar os pedidos",
            description = """
                    Lista todos os pedidos, seguindo o critério:
                    1. Pronto > Em Preparação > Recebido;
                    2. Pedidos mais antigos primeiro e mais novos depois;
                    3. Pedidos com status Finalizado não devem aparecer na lista
                    """
    )
    public ResponseEntity<List<PedidoResponse>> retornarTodosPedidosAbertos() {
        return ResponseEntity.ok().body(pedidoController.retornarTodosPedidosAbertos());
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar pedido pelo ID",
            description = "Retorna o pedido pelo ID",
            parameters = @io.swagger.v3.oas.annotations.Parameter(
                    name = "id",
                    description = "ID do pedido",
                    required = true,
                    example = "123e4567-e89b-12d3-a456-426614174000"
            )
    )
    public ResponseEntity<PedidoResponse> retornarPedidosPorId(@PathVariable String id) {
        return ResponseEntity.ok().body(pedidoController.buscarPedido(id));
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 201, message = "Created")
    })
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "clienteCPF", value = "CPF do cliente", required = true, dataType = "string", paramType = "body"),
            @ApiImplicitParam(name = "produtosUUID", value = "Lista com uuid dos produtos a serem adicionados", required = true, dataType = "array", paramType = "body"),
    })
    @Operation(
            summary = "Checkout do pedido",
            description = "Cadastra o pedido na fila",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Pedido a ser cadastrado",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = PedidoRequest.class),
                            examples = @ExampleObject(
                                    value = "{ \"clienteCPF\": \"123.456.789-00\", \"clienteNome\": \"Foo\", \"itemPedidos\": [{ \"produtoUUID\": \"123e4567-e89b-12d3-a456-426614174000\", \"observacoes\": \"Sem açúcar\", \"quantidade\": 2 }] }"
                            )
                    )
            )
    )
    public ResponseEntity<PedidoResponse> cadastrarPedido(@RequestBody @Valid PedidoRequest pedidoRequest) {
        PedidoResponse pedidoResponse = pedidoController.cadastrarPedido(pedidoRequest);
        return ResponseEntity.created(URI.create("/" + pedidoResponse.getId())).body(pedidoResponse);
    }

}
