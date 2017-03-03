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
        int[] left = new int[size];
        int[] right = new int[size];

        left[0] = blocks[0];
        for (int i = 1; i < size; i++) {
            left[i] = max(left[i - 1], blocks[i]);
        }

        right[size - 1] = blocks[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            right[i] = max(right[i + 1], blocks[i]);
        }

        int volume = 0;
        for (int i = 0; i < size; i++) {
            volume += min(left[i], right[i]) - blocks[i];
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

    /**
     * Calculate minimum between two heights.
     *
     * @param height1
     * @param height2
     * @return int = min(height1, height2)
     */

    private int min(int height1, int height2) {
        return (height1 <= height2 ? height1 : height2);
    }

}
