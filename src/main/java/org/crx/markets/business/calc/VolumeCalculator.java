package org.crx.markets.business.calc;

import org.crx.markets.rest.exception.InternalException;

public interface VolumeCalculator {

    /**
     * Calculates the volume of water.
     *
     * @param blocks array of heights
     * @return volume of water
     */

    int calculateVolume(Integer blocks[]) throws InternalException;
}
