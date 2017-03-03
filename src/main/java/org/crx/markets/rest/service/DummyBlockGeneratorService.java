package org.crx.markets.rest.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.crx.markets.business.domain.Block;
import org.crx.markets.business.domain.BlockList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;

@Path("/volume")
public class DummyBlockGeneratorService extends AbstractRESTService {


    /**
     * Dummy generator of a json for test purposes
     *
     * use rest client (GET) with URL:  http://localhost:8080/ee-array-1/rest/volume/dummy
     * @return json with elements
     */

    @GET
    @Path("dummy")
    @Produces(MediaType.APPLICATION_JSON)
    public String dummy() throws JsonProcessingException {

        Block block1 = new Block();
        block1.setHeight(2);
        Block block2 = new Block();
        block2.setHeight(1);
        BlockList blockList = new BlockList();
        Block block3 = new Block();
        block3.setHeight(4);
        blockList.setBlocks(new ArrayList<>(Arrays.asList(block1, block2, block3)));
        return toJson(blockList);
    }

}
