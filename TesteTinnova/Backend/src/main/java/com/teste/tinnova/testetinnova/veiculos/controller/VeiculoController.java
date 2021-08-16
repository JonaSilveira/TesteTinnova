package com.teste.tinnova.testetinnova.veiculos.controller;

import com.teste.tinnova.testetinnova.veiculos.dao.VeiculoDAO;
import com.teste.tinnova.testetinnova.veiculos.model.Veiculo;
import com.teste.tinnova.testetinnova.veiculos.service.VeiculoService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna lista de veiculos cadastrados"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno"),
    })
    @ResponseStatus(HttpStatus.OK)
    public List<Veiculo> getAll() {
        return veiculoService.getAll();
    }

    @Override
    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um veiculo pelo ip"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno"),
            @ApiResponse(code = 404, message = "Id não encontrado")
    })
    public Veiculo getById(@PathVariable("id") @Valid String id) {
        return veiculoService.getById(id);
    }

    @Override
    @GetMapping("/find")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um ou mais veiculos dado a pesquisa, deve se usar : para igual"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno"), 
    })
    public List<Veiculo> getByQuery(@RequestParam("q") @Valid String q) {
        return veiculoService.getByQuery(q);
    }

    @Override
    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cria um novo veiculo e retorna o veiculo criado"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno"),
    })
    public Veiculo create(@RequestBody @Valid Veiculo defaultClass) {
        return veiculoService.create(defaultClass);
    }

    @Override
    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualiza todo o objeto veiculo"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno"),
    })
    public Veiculo updateAllFields(@PathVariable("id") @Valid String id,@RequestBody @Valid Veiculo defaultClass) {
        return veiculoService.updateAllFields(id, defaultClass);
    }

    @Override
    @PatchMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualiza apenas um campo do objeto veiculo"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno"),
    })
    public Veiculo updateSomeFields(@PathVariable("id") @Valid String id,@RequestBody @Valid  Map<String, Object> fields){
       return veiculoService.updateSomeFields(id,fields);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Deleta um veiculo"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno"),
            @ApiResponse(code = 404, message = "Id não encontrado")
    })
    public String delete(@PathVariable String id) {
        return veiculoService.delete(id);
    }

    @Override
    @GetMapping("/listDecade")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de quantidade de veiculos por decada"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno"), 
    })
    public List<Map<String, Integer>>listDecade()  {
        return veiculoService.listDecade();
    }


    @Override
    @GetMapping("/listMarca")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de quantidade de veiculos por marca"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno"),
    })
    public List<Map<String, String>> listMarca() {
        return veiculoService.listMarca();
    }

    @Override
    @GetMapping("/lastWeek")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de quantidade de veiculos cadastrados na ultima semana"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno"),
    })
    public List<Veiculo>listAllfromLastWeek() {
        return veiculoService.listAllfromLastWeek();
    }


}
