package eu.enedi.infrastructure.controller;


import eu.enedi.infrastructure.dto.EnediDatacenterDto;
import eu.enedi.infrastructure.dto.EnediDatacentersDto;
import eu.enedi.infrastructure.dto.EnediServersDto;
import eu.enedi.infrastructure.services.DatacenterService;
import eu.enedi.infrastructure.services.ServersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/infrastructure/v1")
public class InfrastructureRest {

    @Autowired
    private DatacenterService datacenterService;

    @Autowired
    private ServersService serversService;

    /**************************************************************
     *
     *  GET
     *
     *****************************************************************/

    // Done!
    @CrossOrigin
    @GetMapping(value = "/datacenter/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<EnediDatacentersDto> getAllDatacenters(Pageable p){
        return datacenterService.getAllDatacenters(p);
    }

    //Done!
    @CrossOrigin
    @GetMapping(value = "/datacenter/dcname/{dcName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<EnediDatacentersDto> getDatacenterByName(@PathVariable String dcName, Pageable p){
        return datacenterService.getDatacenterByName(dcName, p);
    }

    //Done
    @CrossOrigin
    @GetMapping(value = "/datacenter/dcid/{dcId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EnediDatacenterDto getDatacenterById(@PathVariable UUID dcId){
        return datacenterService.getDatacenterById(dcId);
    }

    //Done
    @CrossOrigin
    @GetMapping(value = "/datacenter/location/{location}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<EnediDatacentersDto> getDatacenterByLocation(@PathVariable String location, Pageable p){
        return datacenterService.getDatacenterByLocation(location, p);
    }

    /*********************************************************************************************************/

    //Done
    @CrossOrigin
    @GetMapping(value = "/servers/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<EnediServersDto> getAllServers(Pageable p){
        return serversService.getAllServers(p);
    }

    //Done
    @CrossOrigin
    @GetMapping(value = "/servers/id/{sid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EnediServersDto getServerbyId(@PathVariable UUID sid) {
        return serversService.getServerById(sid);
    }

    @CrossOrigin
    @GetMapping(value = "/servers/dc/{dcid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<EnediServersDto> getServerByDc(@PathVariable UUID dcid, Pageable p){
        return serversService.getServerByDc(dcid, p);
    }

    //--------------------------------------------------------------------------------------------------------//

/*


    //Done!
    @CrossOrigin
    @GetMapping(value = "/pv/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EnediPV> getAllPvs(){
        return datacenterService.getAllPv();
    }

    //Done!
    @CrossOrigin
    @GetMapping(value = "/pv/id/{pvid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EnediPV> getPVById(@PathVariable String pvid){
        return datacenterService.getPVById(pvid);
    }

    //Done!
    @CrossOrigin
    @GetMapping(value = "/pv/name/{pvname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EnediPV> getPVByName(@PathVariable String pvname){
        return datacenterService.getPVByName(pvname);
    }

*/


    //---------------------------------------------------------------------------------//

}
