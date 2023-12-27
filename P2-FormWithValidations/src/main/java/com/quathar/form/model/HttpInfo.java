package com.quathar.form.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletRequest;

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
    // Recuerda buscar cabeceras standard, 'sec-ch-ua' y 'sec-ch-ua-platform' no lo son
    public HttpInfo(HttpServletRequest request) {
        // Al final dejo 'sec-ch-ua' y 'sec-ch-ua-platform' porque en el siguiente enlace
        // se aclara que son cabeceras standard.
        // https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers
        ip = request.getRemoteAddr();
        brandVersion = request.getHeader("sec-ch-ua");
        oS = request.getHeader("sec-ch-ua-platform");
        renderEngine = request.getHeader("User-Agent");
        renderEngine = renderEngine.contains("Gecko") ? "Gecko" : renderEngine;
        host = request.getHeader("Host");
        lang = request.getHeader("Accept-Language");
    }

}
