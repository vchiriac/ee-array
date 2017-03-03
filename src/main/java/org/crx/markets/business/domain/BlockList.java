package org.crx.markets.business.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BlockList implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Block> blocks;

    public BlockList() {
        this.blocks = new ArrayList<>();
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }
}