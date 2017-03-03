package org.crx.markets.rest.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.crx.markets.business.calc.VolumeCalculator;
import org.crx.markets.business.domain.Block;
import org.crx.markets.business.domain.BlockList;
import org.crx.markets.rest.exception.InternalException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import static org.crx.markets.business.domain.Response.ResponseBuilder;

@Stateless
@Path("/volume")
public class VolumeCalculatorRESTService extends AbstractRESTService {

    @EJB
    private VolumeCalculator volumeCalculator;

    @POST
    @Path("calculate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String calculateVolumes(final BlockList blocks) throws JsonProcessingException, InternalException {
        return toJson(ResponseBuilder.build(calculateVolume(blocks)));
    }

    private Integer calculateVolume(BlockList blockList) throws InternalException {
        List<Integer> array = new ArrayList<>();
        for (Block block : blockList.getBlocks()) {
            array.add(block.getHeight());
        }
        Integer[] integers = array.toArray(new Integer[array.size()]);

        return volumeCalculator.calculateVolume(integers);
    }

}
