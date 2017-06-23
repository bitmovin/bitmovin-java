package com.bitmovin.api.encoding.encodings.conditions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Roland Kersche on 21.06.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OrConjunction extends AbstractConjunction
{

    public OrConjunction()
    {
        this.setType(ConditionType.OR);
    }
}
