package eu.enedi.infrastructure.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import eu.enedi.infrastructure.entities.enedi.EnediDatacenter;
import eu.enedi.infrastructure.services.DatacenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GraphqlQuery implements GraphQLQueryResolver {

    @Autowired
    private DatacenterService datacenterService;

    public List<EnediDatacenter> datacentersAll(){
        return datacenterService.getAllDatacentersList();
    }


    public EnediDatacenter datacenterById(UUID dcid){
        try {
            return datacenterService.getDcById(dcid);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
