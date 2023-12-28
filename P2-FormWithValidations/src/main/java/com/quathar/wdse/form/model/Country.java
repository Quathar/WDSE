package com.quathar.wdse.form.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <h1>Country Model</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
@Getter
public class Country {

    // <<-FIELDS->>
    private String name;
    private String language;
    private String prefix;
    private Boolean show;
    private String flag;

}
