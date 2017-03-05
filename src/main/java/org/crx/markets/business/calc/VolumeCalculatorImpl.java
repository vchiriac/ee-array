package org.crx.markets.business.calc;


import org.crx.markets.rest.exception.InternalException;

import javax.ejb.Stateless;

@Stateless
public class VolumeCalculatorImpl implements VolumeCalculator {

    /**
     * Calculates the volume of water.
     *
     * @param blocks array of heights
     * @return int = volume of water
     */

    @Override
    public int calculateVolume(Integer[] blocks) throws InternalException {

        if (blocks == null) {
            throw InternalException.build("Array cannot be null.");
        }

        int size = blocks.length;
        int left = 0;
        int right = size - 1;
        int maxValue = 0;
        int volume = 0;
        while(left < right) {
            if (blocks[left] < blocks[right]) {
                maxValue = max(blocks[left], maxValue);
                volume += maxValue - blocks[left];
                left ++;
            } else {
                maxValue = max(blocks[right], maxValue);
                volume += maxValue - blocks[right];
                right --;
            }
        }
        return volume;
    }

    /**
     * Calculate maximum between two heights.
     *
     * @param height1
     * @param height2
     * @return int = max(height1, height2)
     */

    private int max(int height1, int height2) {
        return (height1 >= height2 ? height1 : height2);
    }
}
