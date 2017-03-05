package org.crx.markets.business.transform;


import org.crx.markets.business.domain.BlockList;

public interface Transformer {

    /**
     * Transforms the input parameters into array of Integer for better calculation optimization.
     *
     * @param blockList input parameters
     * @return array of Integer
     */

    Integer[] transform(BlockList blockList);
}
