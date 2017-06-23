package com.bitmovin.api.encoding.encodings.conditions;

import java.util.List;

/**
 * Created by Roland Kersche on 21.06.17.
 */
public class AbstractConjunction extends AbstractCondition
{
    private List<AbstractCondition> conditions;

    public List<AbstractCondition> getConditions()
    {
        return conditions;
    }

    public void setConditions(List<AbstractCondition> conditions)
    {
        this.conditions = conditions;
    }
}
