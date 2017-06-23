package com.bitmovin.api.encoding.encodings.conditions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by Roland Kersche on 21.06.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AndConjunction.class, name = "AND"),
        @JsonSubTypes.Type(value = OrConjunction.class, name = "OR"),
        @JsonSubTypes.Type(value = Condition.class, name = "CONDITION"),
})
public abstract class AbstractCondition
{
    private ConditionType type;

    public ConditionType getType()
    {
        return this.type;
    }

    public void setType(ConditionType type)
    {
        this.type = type;
    }
}
