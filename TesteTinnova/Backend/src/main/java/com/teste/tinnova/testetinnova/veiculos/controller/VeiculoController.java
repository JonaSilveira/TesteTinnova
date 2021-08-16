package com.teste.tinnova.testetinnova.veiculos.controller;

import com.teste.tinnova.testetinnova.veiculos.dao.VeiculoDAO;
import com.teste.tinnova.testetinnova.veiculos.model.Veiculo;
import com.teste.tinnova.testetinnova.veiculos.service.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/veiculos")
public class VeiculoController implements VeiculoDAO {

    @Autowired
    VeiculoService veiculoService;

    @Override
    @GetMapping
    @ResponseBody
    @Operation(summary = "Retorna lista de veiculos cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retornou lista de veiculos",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Veiculo.class)) }),
            @ApiResponse(responseCode = "500", description = "Ocorreu um erro interno",
                    content = @Content) })
    @ResponseStatus(HttpStatus.OK)
    public List<Veiculo> getAll() {
        return veiculoService.getAll();
    }

    @Override
    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Retorna um veiculo pelo ip")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Achou o veiculo e o retornou",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Veiculo.class)) }),
            @ApiResponse(responseCode = "404", description = "Id não encontrado",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Veiculo.class)) }),
            @ApiResponse(responseCode = "500", description = "Ocorreu um erro interno",
                    content = @Content) })
    public Veiculo getById(@PathVariable("id") @Valid String id) {
        return veiculoService.getById(id);
    }

    @Override
    @GetMapping("/find")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Retorna um ou mais veiculos dado uma pesquisa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Achou o veiculo e o retornou",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Veiculo.class)) }),
            @ApiResponse(responseCode = "500", description = "Ocorreu um erro interno",
                    content = @Content) })
    public List<Veiculo> getByQuery(@RequestParam("q") @Valid String q) {
        return veiculoService.getByQuery(q);
    }

    @Override
    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cria um novo veiculo e retorna o veiculo criado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Criado com sucesso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Veiculo.class)) }),
            @ApiResponse(responseCode = "500", description = "Ocorreu um erro interno",
                    content = @Content) })
    public Veiculo create(@RequestBody @Valid Veiculo defaultClass) {
        return veiculoService.create(defaultClass);
    }

    @Override
    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary =  "Atualiza todo o objeto veiculo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualizado com sucesso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Veiculo.class)) }),
            @ApiResponse(responseCode = "404", description = "Id não encontrado",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Veiculo.class)) }),
            @ApiResponse(responseCode = "500", description = "Ocorreu um erro interno",
                    content = @Content) })
    public Veiculo updateAllFields(@PathVariable("id") @Valid String id,@RequestBody @Valid Veiculo defaultClass) {
        return veiculoService.updateAllFields(id, defaultClass);
    }

    @Override
    @PatchMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary =  "Atualiza apenas um campo do objeto veiculo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualizado com sucesso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Veiculo.class)) }),
            @ApiResponse(responseCode = "404", description = "Id não encontrado",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Veiculo.class)) }),
            @ApiResponse(responseCode = "500", description = "Ocorreu um erro interno",
                    content = @Content) })
    public Veiculo updateSomeFields(@PathVariable("id") @Valid String id,@RequestBody @Valid  Map<String, Object> fields){
       return veiculoService.updateSomeFields(id,fields);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary =  "Deleta um veiculoo dado um id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deletado com sucesso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Veiculo.class)) }),
            @ApiResponse(responseCode = "404", description = "Id não encontrado",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Veiculo.class)) }),
            @ApiResponse(responseCode = "500", description = "Ocorreu um erro interno",
                    content = @Content) })
    public String delete(@PathVariable String id) {
        return veiculoService.delete(id);
    }

    @Override
    @GetMapping("/listDecade")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Retorna uma lista de quantidade de veiculos por decada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retornou lista de veiculos",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Veiculo.class)) }),
            @ApiResponse(responseCode = "500", description = "Ocorreu um erro interno",
                    content = @Content) })
    public List<Map<String, Integer>>listDecade()  {
        return veiculoService.listDecade();
    }


    @Override
    @GetMapping("/listMarca")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Retorna uma lista de quantidade de veiculos por marca")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retornou lista de veiculos",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Veiculo.class)) }),
            @ApiResponse(responseCode = "500", description = "Ocorreu um erro interno",
                    content = @Content) })
    public List<Map<String, String>> listMarca() {
        return veiculoService.listMarca();
    }

    @Override
    @GetMapping("/lastWeek")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Retorna uma lista veiculos cadastrados na ultima semana")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retornou lista de veiculos",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Veiculo.class)) }),
            @ApiResponse(responseCode = "500", description = "Ocorreu um erro interno",
                    content = @Content) })
    public List<Veiculo>listAllfromLastWeek() {
        return veiculoService.listAllfromLastWeek();
    }


}
