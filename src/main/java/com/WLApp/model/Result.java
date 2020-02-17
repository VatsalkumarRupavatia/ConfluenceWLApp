
package com.WLApp.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "title",
    "childTypes",
    "macroRenderedOutput",
    "restrictions"
})
public class Result {

    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("childTypes")
    private ChildTypes childTypes;
    @JsonProperty("macroRenderedOutput")
    private MacroRenderedOutput macroRenderedOutput;
    @JsonProperty("restrictions")
    private Restrictions restrictions;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("childTypes")
    public ChildTypes getChildTypes() {
        return childTypes;
    }

    @JsonProperty("childTypes")
    public void setChildTypes(ChildTypes childTypes) {
        this.childTypes = childTypes;
    }

    @JsonProperty("macroRenderedOutput")
    public MacroRenderedOutput getMacroRenderedOutput() {
        return macroRenderedOutput;
    }

    @JsonProperty("macroRenderedOutput")
    public void setMacroRenderedOutput(MacroRenderedOutput macroRenderedOutput) {
        this.macroRenderedOutput = macroRenderedOutput;
    }

    @JsonProperty("restrictions")
    public Restrictions getRestrictions() {
        return restrictions;
    }

    @JsonProperty("restrictions")
    public void setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("title", title).append("childTypes", childTypes).append("macroRenderedOutput", macroRenderedOutput).append("restrictions", restrictions).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(childTypes).append(macroRenderedOutput).append(restrictions).append(id).append(additionalProperties).append(title).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Result) == false) {
            return false;
        }
        Result rhs = ((Result) other);
        return new EqualsBuilder().append(childTypes, rhs.childTypes).append(macroRenderedOutput, rhs.macroRenderedOutput).append(restrictions, rhs.restrictions).append(id, rhs.id).append(additionalProperties, rhs.additionalProperties).append(title, rhs.title).isEquals();
    }

}
