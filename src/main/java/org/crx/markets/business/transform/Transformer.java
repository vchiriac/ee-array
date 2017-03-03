package org.crx.markets.business.transform;


import org.crx.markets.business.domain.BlockList;

public interface Transformer {

    Integer[] transform(BlockList blockList);
}
