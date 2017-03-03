package org.crx.markets.business.domain;

import java.io.Serializable;

public class Response implements Serializable {

    private static final long serialVersionUID = 1L;

    private int volume;

    public int getVolume() {
        return volume;
    }

    public Response(int volume) {
        this.volume = volume;
    }

    public static final class ResponseBuilder {

        private ResponseBuilder() {
        }

        public static Response build(int volume) {
            Response response = new Response(volume);
            return response;
        }
    }

}
