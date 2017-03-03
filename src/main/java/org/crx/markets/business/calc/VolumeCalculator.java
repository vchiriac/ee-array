package org.crx.markets.business.calc;

import org.crx.markets.rest.exception.InternalException;

/**
 * Created by vali on 02/03/2017.
 */
public interface VolumeCalculator {

    int calculateVolume(Integer arr[]) throws InternalException;
}
