package eu.enedi.infrastructure.services;

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
public class ServersService {


    @Autowired
    private EnediServersRepository enediServersRepository;

    @Autowired
    private EnediDatacenterRepository enediDatacenterRepository;

    @Autowired
    private EnediRackRepository enediRackRepository;


    public Page<EnediServersDto> getAllServers(Pageable p){
        Page<EnediServer> enediServers = enediServersRepository.findAll(p);
        Page<EnediServersDto> dtoPage = enediServers.map(new Function<EnediServer, EnediServersDto>() {
            @Override
            public EnediServersDto apply(EnediServer enediServer) {
                EnediServersDto dto = convertServersToServersDto(enediServer);
                return dto;
            }
        });
        return dtoPage;
    }

    public EnediServersDto getServerById(UUID sid) {
        EnediServer server = enediServersRepository.findEnediServerBySerId(sid);
        return this.convertServersToServersDto(server);
    }

    public Page<EnediServersDto> getServerByDc(UUID dcid, Pageable p){
        EnediDatacenter enediDatacenter = enediDatacenterRepository.findById(dcid).orElseThrow(NoSuchElementException::new);
        Page<EnediServer> enediServers = enediServersRepository.findAllByEnediDatacenter(enediDatacenter,p);
        Page<EnediServersDto> dtoPage = enediServers.map(new Function<EnediServer, EnediServersDto>() {
            @Override
            public EnediServersDto apply(EnediServer enediServer) {
                EnediServersDto dto = convertServersToServersDto(enediServer);
                return dto;
            }
        });
        return dtoPage;
    }

    public Page<EnediServer> getServersByRack(UUID rackId, Pageable p){

        EnediRack rack = enediRackRepository.findById(rackId).orElseThrow(NoSuchElementException::new);
        return enediServersRepository.findAllByEnediRack(rack, p);
    }


    //-------------------------Convert to Dtos ----------------------------//

    private EnediServersDto convertServersToServersDto(EnediServer enediServer){
        PropertyMap<EnediServer, EnediServersDto> propertyMap = new PropertyMap<EnediServer, EnediServersDto>() {
            @Override
            protected void configure() {
                map().setSerId(source.getSerId());
                map().setServerName(source.getServerName());
                map().setNumOfCores(source.getNumOfCores());
                map().setRamInMB(source.getRamInMB());
                map().setOperatingSystem(source.getOperatingSystem());
                map().setIpAddress(source.getIpAddress());
                map().setDcId(source.getEnediDatacenter().getDcid());
                map().setDcName(source.getEnediDatacenter().getName());
                map().setRackId(source.getEnediRack().getRackId());
                map().setRackName(source.getEnediRack().getRackName());
                map().setServerHealth("Healthy");
            }
        };

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(propertyMap);

        EnediServersDto dto = modelMapper.map(enediServer, EnediServersDto.class);
        return dto;
    }

}
