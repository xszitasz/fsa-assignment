package sk.posam.fsa.mapper;

import org.springframework.stereotype.Component;
import sk.posam.fsa.Credit;
import sk.posam.fsa.rest.dto.CreditDto;

@Component
public class CreditMapper {
    public CreditDto toCreditDto(Credit entity) {
        if (entity == null) { return null;}

        CreditDto dto = new CreditDto();
        dto.setId(entity.getId());
        dto.setCount((int) entity.getCount());
        return dto;
    }

    public Credit toCreditEntity(CreditDto dto) {
        if (dto == null) { return null;}

        Credit entity = new Credit();
        entity.setId(dto.getId());
        entity.setCount(dto.getCount());
        return entity;
    }
}


