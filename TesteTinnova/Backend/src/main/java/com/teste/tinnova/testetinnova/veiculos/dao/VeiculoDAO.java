package com.teste.tinnova.testetinnova.veiculos.dao;

import com.teste.tinnova.testetinnova.veiculos.model.Veiculo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface VeiculoDAO {

    List<Veiculo> getAll();

    Veiculo getById(String id);

    List<Veiculo> getByQuery(String q);

    Veiculo create(Veiculo defaultClass);

    Veiculo updateAllFields(String id, Veiculo defaultClass);

    Veiculo updateSomeFields(String id, Map<String, Object> fields);

    String delete(String id);

    List<Map<String, Integer>>listDecade();

    List<Map<String, String>>listMarca();

    List<Veiculo> listAllfromLastWeek();

}
