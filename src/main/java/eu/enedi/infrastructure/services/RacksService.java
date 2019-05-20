package eu.enedi.infrastructure.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import eu.enedi.infrastructure.dto.EnediRacksDto;
import eu.enedi.infrastructure.dto.EnediServersDto;
import eu.enedi.infrastructure.entities.enedi.EnediDatacenter;
import eu.enedi.infrastructure.entities.enedi.EnediRack;
import eu.enedi.infrastructure.entities.enedi.EnediServer;
import eu.enedi.infrastructure.repositories.EnediDatacenterRepository;
import eu.enedi.infrastructure.repositories.EnediRackRepository;
import eu.enedi.infrastructure.repositories.EnediServersRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.function.Function;

@Service
public class RacksService {


    @Autowired
    private EnediRackRepository enediRackRepository;

    @Autowired
    private EnediServersRepository enediServersRepository;

    @Autowired
    private EnediDatacenterRepository enediDatacenterRepository;



    public Page<EnediRacksDto> getAllRacks(Pageable p){
        Page<EnediRack> enediRacks = enediRackRepository.findAll(p);

        Page<EnediRacksDto> dtoPage = enediRacks.map(new Function<EnediRack, EnediRacksDto>() {
            @Override
            public EnediRacksDto apply(EnediRack enediRack) {
                EnediRacksDto dto = convertRacksToRacksDto(enediRack);
                return dto;
            }
        });
        return dtoPage;
    }

    public Page<EnediRacksDto> getDCRacks(UUID dcid, Pageable p){
        EnediDatacenter enediDatacenter = enediDatacenterRepository.findById(dcid).orElseThrow(NoSuchElementException::new);
        return null;
    }



    //-------------------------Convert to Dtos ----------------------------//

    private EnediRacksDto convertRacksToRacksDto(EnediRack enediRack){
        ObjectMapper objectMapper = new ObjectMapper();
        PropertyMap<EnediRack, EnediRacksDto> propertyMap = new PropertyMap<EnediRack, EnediRacksDto>() {
            @Override
            protected void configure() {

                map().setRackId(source.getRackId());
                map().setRackName(source.getRackName());
                map().setEnediServers(source.getEnediServers());
            }
        };

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(propertyMap);

        EnediRacksDto dto = modelMapper.map(enediRack, EnediRacksDto.class);
        return dto;
    }



}
