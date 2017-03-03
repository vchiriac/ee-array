package org.crx.markets.business.domain;

import java.io.Serializable;

public class Block implements Serializable {
    private static final long serialVersionUID = 1L;

    private int height;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


}
