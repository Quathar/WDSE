package com.quathar.wdse.form.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletRequest;

/**
 * <h1>HTTP Info</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
@NoArgsConstructor
@Data
public class HttpInfo {

    // <<-FIELDS->>
    private String ip;
    private String brandVersion;
    private String oS;
    private String renderEngine;
    private String host;
    private String lang;

    // <<-CONSTRUCTOR->>
    public HttpInfo(HttpServletRequest request) {
        // At the end I leave 'sec-ch-ua' and 'sec-ch-ua-platform' because in the following link
        // makes it clear that they are standard headers.
        // https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers
        this.ip           = request.getRemoteAddr();
        this.brandVersion = request.getHeader("sec-ch-ua");
        this.oS           = request.getHeader("sec-ch-ua-platform");
        this.renderEngine = request.getHeader("User-Agent");
        this.renderEngine = renderEngine.contains("Gecko") ? "Gecko" : renderEngine;
        this.host         = request.getHeader("Host");
        this.lang         = request.getHeader("Accept-Language");
    }

}
