
package aiss.model.tmaster;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "startDateTime",
    "startApproximate",
    "endApproximate"
})
public class Access {

    @JsonProperty("startDateTime")
    private String startDateTime;
    @JsonProperty("startApproximate")
    private Boolean startApproximate;
    @JsonProperty("endApproximate")
    private Boolean endApproximate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("startDateTime")
    public String getStartDateTime() {
        return startDateTime;
    }

    @JsonProperty("startDateTime")
    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    @JsonProperty("startApproximate")
    public Boolean getStartApproximate() {
        return startApproximate;
    }

    @JsonProperty("startApproximate")
    public void setStartApproximate(Boolean startApproximate) {
        this.startApproximate = startApproximate;
    }

    @JsonProperty("endApproximate")
    public Boolean getEndApproximate() {
        return endApproximate;
    }

    @JsonProperty("endApproximate")
    public void setEndApproximate(Boolean endApproximate) {
        this.endApproximate = endApproximate;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
