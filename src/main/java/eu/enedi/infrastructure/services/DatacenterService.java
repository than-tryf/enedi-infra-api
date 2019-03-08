package eu.enedi.infrastructure.services;

import com.ecwid.consul.v1.ConsulClient;
import eu.enedi.infrastructure.dto.EnediDatacenterDto;
import eu.enedi.infrastructure.dto.EnediDatacentersDto;
import eu.enedi.infrastructure.entities.enedi.EnediDatacenter;
import eu.enedi.infrastructure.entities.enedi.EnediServer;
import eu.enedi.infrastructure.repositories.EnediDatacenterRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.function.Function;

@Service
public class DatacenterService {

    private ConsulClient consulClient;

    @Autowired
    private EnediDatacenterRepository enediDatacenterRepository;

    public DatacenterService() {
        //TODO: Add this into Config file
        ConsulClient client = new ConsulClient("http://10.16.3.167");
        this.consulClient = client;
    }

    public Page<EnediDatacentersDto> getAllDatacenters(Pageable p){
        Page<EnediDatacenter> edc = enediDatacenterRepository.findAll(p);
        Page<EnediDatacentersDto> dtoPage = edc.map(new Function<EnediDatacenter, EnediDatacentersDto>() {
            @Override
            public EnediDatacentersDto apply(EnediDatacenter enediDatacenter) {
                EnediDatacentersDto dto = convertDatacentersToDatacentersDto(enediDatacenter);

                return dto;
            }
        });
        return dtoPage;
    }

    public Page<EnediDatacentersDto> getDatacenterByName(String dcName, Pageable p){
        Page<EnediDatacenter> edc = enediDatacenterRepository.findAllByNameContainsIgnoreCase(dcName, p);
        Page<EnediDatacentersDto> dtoPage = edc.map(new Function<EnediDatacenter, EnediDatacentersDto>() {
            @Override
            public EnediDatacentersDto apply(EnediDatacenter enediDatacenter) {
                EnediDatacentersDto dto = convertDatacentersToDatacentersDto(enediDatacenter);

                return dto;
            }
        });

        return dtoPage;
    }

    public EnediDatacenterDto getDatacenterById(UUID dcId){
        EnediDatacenter edc = enediDatacenterRepository.findEnediDatacenterByDcid(dcId);
        if (edc == null){
            throw new NoSuchElementException();
        }
        return this.convertDatacenterToDatacenterDto(edc);
    }

    public Page<EnediDatacentersDto> getDatacenterByLocation(String location, Pageable p){
        Page<EnediDatacenter> edc = enediDatacenterRepository.findAllByCityContainsIgnoreCaseOrCountryContainsIgnoreCase(location, location, p);
        Page<EnediDatacentersDto> dtoPage = edc.map(new Function<EnediDatacenter, EnediDatacentersDto>() {
            @Override
            public EnediDatacentersDto apply(EnediDatacenter enediDatacenter) {
                EnediDatacentersDto dto = convertDatacentersToDatacentersDto(enediDatacenter);

                return dto;
            }
        });

        return dtoPage;
    }



 //--------------------------------------------------------------------------------------------//

    public List<EnediServer> dummyFunc(){

        return null;

    }


    //---------------------Convert to Dtos-----------------------------------//

    private EnediDatacentersDto convertDatacentersToDatacentersDto(EnediDatacenter dc){
        PropertyMap<EnediDatacenter, EnediDatacentersDto> dcMap = new PropertyMap<EnediDatacenter, EnediDatacentersDto>() {
            @Override
            protected void configure() {
                map().setDcid(source.getDcid());
                map().setName(source.getName());
                map().setCountry(source.getCountry());
                map().setCity(source.getCity());
                map().setLatitude(source.getLatitude());
                map().setLongtitude(source.getLongtitude());
                map().setDcPrefix(source.getDcPrefix());
            }
        };

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(dcMap);

        EnediDatacentersDto dto = modelMapper.map(dc, EnediDatacentersDto.class);
        return dto;
    }


    private EnediDatacenterDto convertDatacenterToDatacenterDto(EnediDatacenter dc){
        PropertyMap<EnediDatacenter, EnediDatacenterDto> dcMap = new PropertyMap<EnediDatacenter, EnediDatacenterDto>() {
            @Override
            protected void configure() {
                map().setDcid(source.getDcid());
                map().setName(source.getName());
                map().setCountry(source.getCountry());
                map().setCity(source.getCity());
                map().setLatitude(source.getLatitude());
                map().setLongtitude(source.getLongtitude());
                map().setDcPrefix(source.getDcPrefix());

                //Hardcoded Values
                map().setHealth("Healthy");
                map().setTotalDcConsumption(50.5);
                map().setTotalDcCPU(150);
                map().setTotalDcMemory(40960);
                map().setTotalNumOfServers(100);
                map().setTotalNumberOfDataloggers(2);
            }
        };

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(dcMap);

        EnediDatacenterDto dto = modelMapper.map(dc, EnediDatacenterDto.class);
        return dto;
    }
}
