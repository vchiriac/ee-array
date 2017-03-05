package org.crx.markets.business.transform;

import org.crx.markets.business.AbstractTest;
import org.crx.markets.business.domain.Block;
import org.crx.markets.business.domain.BlockList;
import org.junit.Before;
import org.junit.Test;

import javax.naming.NamingException;
import static junit.framework.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertNotNull;


public class TransformerTest extends AbstractTest {

    private Transformer transformer;

    @Before
    public void bootContainer() throws Exception {
        try {
            transformer = (Transformer) ctx.lookup("java:global/classes/TransformerImpl");
        } catch (NamingException e) {
            throw new AssertionError(e);
        }

    }

    @Test
    public void transformTest() {
        assertNotNull(transformer);
        BlockList blockList = createBlocks();

        Integer[] blockArray = new Integer[]{3,2,1};
        Integer[] transformed = transformer.transform(blockList);

        assertEquals(true, Arrays.equals(blockArray,transformed));
    }

    private BlockList createBlocks() {
        Block block1 = new Block();
        block1.setHeight(3);
        Block block2 = new Block();
        block2.setHeight(2);
        BlockList blockList = new BlockList();
        Block block3 = new Block();
        block3.setHeight(1);
        blockList.setBlocks(new ArrayList<>(Arrays.asList(block1, block2, block3)));
        return blockList;
    }
}
