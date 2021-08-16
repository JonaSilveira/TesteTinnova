package com.teste.tinnova.testetinnova.veiculos.service;

import com.teste.tinnova.testetinnova.exceptions.NotFoundRequestException;
import com.teste.tinnova.testetinnova.veiculos.dao.VeiculoDAO;
import com.teste.tinnova.testetinnova.veiculos.model.Veiculo;
import com.teste.tinnova.testetinnova.veiculos.repository.VeiculoRepository;
import com.teste.tinnova.testetinnova.veiculos.specification.SearchCriteria;
import com.teste.tinnova.testetinnova.veiculos.specification.VeiculoSpecification;
import com.teste.tinnova.testetinnova.veiculos.specification.VeiculoSpecificationsBuilder;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.criteria.internal.predicate.BooleanExpressionPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Transactional
public class VeiculoService implements VeiculoDAO {

    @Autowired
    VeiculoRepository veiculoRepository;

    @Override
    public List<Veiculo> getAll() {
        List<Veiculo> veiculos = new ArrayList<>();
        veiculoRepository.findAll().forEach(veiculos::add);
        return veiculos;
    }

    @Override
    public Veiculo getById(String id) {
        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);
        return veiculoOptional.orElseThrow(()->new NotFoundRequestException("Veiculo não encontrado!"));
    }
    @Override
    public List<Veiculo> getByQuery(String q){
        System.out.println(q);
        VeiculoSpecificationsBuilder builder = new VeiculoSpecificationsBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(q + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), removeAccents(matcher.group(3)));
        }
        Specification<Veiculo> spec = builder.build();
        List<Veiculo> veiculos = veiculoRepository.findAll(spec);
        return veiculos;
    }

    @Override
    public Veiculo create(Veiculo defaultClass) {
        Veiculo veiculo =defaultClass;
        return veiculoRepository.save(veiculo);
    }

    @Override
    public Veiculo updateAllFields(String id, Veiculo defaultClass) {
        Veiculo veiculo = defaultClass;
        return veiculoRepository.save(veiculo);
    }

    @Override
    public Veiculo updateSomeFields(String id, Map<String, Object> fields) {
        if(fields==null||fields.isEmpty())
            throw new RuntimeException("Dados invalidos");

        Veiculo veiculo =  getById(id);

        if(veiculo == null)
            throw new NotFoundRequestException("Veiculo não existe!");

        fields.remove("id");
        fields.remove("created");
        fields.remove("updated");
        fields.forEach((k,v)->{
            Field field = ReflectionUtils.findField(Veiculo.class,k);
            field.setAccessible(true);
            ReflectionUtils.setField(field,veiculo,v);
        });
        return veiculoRepository.save(veiculo);
    }

    @Override
    public String delete(String id) {
        Veiculo veiculo = getById(id);
        veiculoRepository.delete(veiculo);
        return id;
    }

    @Override
    public List<Map<String, Integer>> listDecade() {
        List<Map<String, Integer>> veiculos = new ArrayList<>();
        veiculoRepository.listAno().forEach(v->{
            Map<String, Integer> veiculoAno = new HashMap<>();
            String[] split = v.split(",");
            Integer quantidade = Integer.parseInt(split[0]);
            Integer ano = Integer.parseInt(split[1]+"0");
            veiculoAno.put("quantidade", quantidade);
            veiculoAno.put("ano", ano);
            veiculos.add(veiculoAno);
        });
        return veiculos;
    }

    @Override
    public List<Map<String, String>> listMarca() {
        List<Map<String, String>> veiculos = new ArrayList<>();
        veiculoRepository.listMarca().forEach(v->{
            Map<String, String> veiculoAno = new HashMap<>();
            String[] split = v.split(",");
            String quantidade = split[0];
            String marca = split[1];
            veiculoAno.put("quantidade", quantidade);
            veiculoAno.put("marca", marca);
            veiculos.add(veiculoAno);
        });
        return veiculos;
    }

    @Override
    public List<Veiculo> listAllfromLastWeek() {
        List<LocalDate> lw = calculeLastWeek();
        return veiculoRepository.listAllfromLastWeek(lw.get(0),lw.get(1));
    }

    public List<LocalDate>calculeLastWeek(){
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int i = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
        c.add(Calendar.DATE, -i - 7);
        Date start = c.getTime();
        c.add(Calendar.DATE, 6);
        Date end = c.getTime();
        LocalDate inicio = dateToLocaldate(start);
        LocalDate fim = dateToLocaldate(end);
        return Arrays.asList(inicio,fim);
    }

    public LocalDate dateToLocaldate(Date dateToConvert){
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public String removeAccents(String text) {
        return text == null ? null : Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
}
