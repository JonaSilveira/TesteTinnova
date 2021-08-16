package com.teste.tinnova.testetinnova.veiculos.specification;

import com.teste.tinnova.testetinnova.veiculos.model.Veiculo;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VeiculoSpecificationsBuilder {
    private final List<SearchCriteria> params;

    public VeiculoSpecificationsBuilder() {
        params = new ArrayList<SearchCriteria>();
    }

    public VeiculoSpecificationsBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public Specification<Veiculo> build() {
        if (params.size() == 0) {
            return null;
        }

        List<Specification> specs = params.stream()
                .map(VeiculoSpecification::new)
                .collect(Collectors.toList());

        Specification result = specs.get(0);

        return result;
    }
}
