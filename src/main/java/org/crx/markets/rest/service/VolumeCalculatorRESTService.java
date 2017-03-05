package org.crx.markets.rest.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.crx.markets.business.calc.VolumeCalculator;
import org.crx.markets.business.domain.BlockList;
import org.crx.markets.business.transform.Transformer;
import org.crx.markets.rest.exception.InternalException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static org.crx.markets.business.domain.Response.ResponseBuilder;

@Stateless
@Path("/volume")
public class VolumeCalculatorRESTService extends AbstractRESTService {

    @EJB
    private VolumeCalculator volumeCalculator;

    @EJB
    private Transformer transformer;


    /**
     * Dummy generator of a json for test purposes
     *
     * use rest client (POST) with URL:  http://localhost:8080/ee-array-1/rest/volume/calculate
     * @return json with calculated volume
     */
    @POST
    @Path("calculate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String calculateVolumes(final BlockList blocks) throws JsonProcessingException, InternalException {
        return toJson(ResponseBuilder.build(calculateVolume(blocks)));
    }

    /**
     * Transforms json to internal array, and calculates the volume of water.
     *
     * @param blockList array of heights
     * @return volume of water
     */
    private Integer calculateVolume(BlockList blockList) throws InternalException {

        Integer[] blocks = transformer.transform(blockList);
        return volumeCalculator.calculateVolume(blocks);
    }

}
