package org.crx.markets.business.transform;

import org.crx.markets.business.domain.Block;
import org.crx.markets.business.domain.BlockList;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class TransformerImpl implements Transformer {


    /**
     * Transforms the input parameters into array of Integer for better calculation optimization.
     *
     * @param blockList input parameters
     * @return array of Integer
     */
    @Override
    public Integer[] transform(BlockList blockList) {

        List<Integer> list = new ArrayList<>();
        for (Block block : blockList.getBlocks()) {
            list.add(block.getHeight());
        }

        return list.toArray(new Integer[list.size()]);
    }
}
