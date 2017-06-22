package com.bitmovin.api.encoding.encodings.conditions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Roland Kersche on 21.06.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Condition extends AbstractCondition
{

    private ConditionAttribute attribute;
    private String operator;
    private String value;

    public Condition()
    {
        this.setType(ConditionType.CONDITION);
    }

    public Condition(ConditionAttribute attribute, String operator, String value)
    {
        this();
        this.attribute = attribute;
        this.operator = operator;
        this.value = value;
    }

    public ConditionAttribute getAttribute()
    {
        return this.attribute;
    }

    public void setAttribute(ConditionAttribute attribute)
    {
        this.attribute = attribute;
    }

    public String getOperator()
    {
        return this.operator;
    }

    public void setOperator(String operator)
    {
        this.operator = operator;
    }

    public String getValue()
    {
        return this.value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }
}
