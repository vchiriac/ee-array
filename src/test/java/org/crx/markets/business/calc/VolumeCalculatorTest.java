package org.crx.markets.business.calc;

import org.crx.markets.business.AbstractTest;
import org.crx.markets.rest.exception.InternalException;
import org.junit.Before;
import org.junit.Test;

import javax.naming.NamingException;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class VolumeCalculatorTest extends AbstractTest {


    private VolumeCalculator volumeCalculator;

    @Before
    public void bootContainer() throws Exception {
        try {
            volumeCalculator = (VolumeCalculator) ctx.lookup("java:global/classes/VolumeCalculatorImpl");
        } catch (NamingException e) {
            throw new AssertionError(e);
        }

    }

    @Test
    public void testVolume() throws Exception {
        assertNotNull(volumeCalculator);
        Integer[] array = new Integer[]{3, 0, 0, 2, 0, 4};
        int result = volumeCalculator.calculateVolume(array);
        assertNotNull(result);
        assertEquals(10, result);
    }

    @Test
    public void testVolumeZero() throws Exception {
        assertNotNull(volumeCalculator);
        Integer[] array = new Integer[]{3, 2, 1};
        int result = volumeCalculator.calculateVolume(array);
        assertNotNull(result);
        assertEquals(0, result);
    }

    @Test(expected = InternalException.class)
    public void testVolumeNoElements() throws Exception {
        assertNotNull(volumeCalculator);
        Integer[] array = null;
        int result = volumeCalculator.calculateVolume(array);
    }
}
