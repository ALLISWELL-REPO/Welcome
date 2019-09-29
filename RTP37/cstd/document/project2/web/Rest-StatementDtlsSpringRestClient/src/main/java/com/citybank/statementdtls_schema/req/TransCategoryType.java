package com.citybank.statementdtls_schema.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("TransCategoryType")
public class TransCategoryType {
	
	@JsonProperty
    protected DateRangeType dateRange;
    protected String typeOfCategory;

   
    public DateRangeType getDateRange() {
        return dateRange;
    }

  
    public void setDateRange(DateRangeType value) {
        this.dateRange = value;
    }

    public String getTypeOfCategory() {
        return typeOfCategory;
    }

    public void setTypeOfCategory(String value) {
        this.typeOfCategory = value;
    }

}
