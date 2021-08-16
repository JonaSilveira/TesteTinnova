package com.teste.tinnova.testetinnova.veiculos.repository;

import com.teste.tinnova.testetinnova.veiculos.model.Veiculo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface VeiculoRepository extends CrudRepository<Veiculo, String>, JpaSpecificationExecutor<Veiculo> {
    Integer countVeiculosByVendido(Boolean vendido);

    @Query(value = "select count(ano), LEFT(ano,char_length(ano)-1) as a from veiculo group by a order by a",nativeQuery = true)
    List<String> listAno();

    @Query("select count(veiculo.marca), veiculo.marca from Veiculo group by veiculo.marca order by veiculo.marca")
    List<String> listMarca();

    @Query("select veiculo from Veiculo veiculo where veiculo.created >=:inicioSemana and veiculo.created <=:fimSemana")
    List<Veiculo> listAllfromLastWeek(LocalDate inicioSemana, LocalDate fimSemana);

}
