package org.crx.markets.calc;

import org.crx.markets.business.calc.VolumeCalculator;
import org.crx.markets.rest.exception.InternalException;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class VolumeCalculatorTest {

    private static EJBContainer ejbContainer;
    private static Context ctx;
    private VolumeCalculator volumeCalculator;

    @BeforeClass
    public static void setUp() {
        ejbContainer = EJBContainer.createEJBContainer();
        ctx = ejbContainer.getContext();
    }

    @AfterClass
    public static void tearDown() {
        ejbContainer.close();
    }

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
