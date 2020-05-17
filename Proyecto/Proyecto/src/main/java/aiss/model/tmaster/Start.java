
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
    "localDate",
    "localTime",
    "dateTime",
    "dateTBD",
    "dateTBA",
    "timeTBA",
    "noSpecificTime"
})
public class Start {

    @JsonProperty("localDate")
    private String localDate;
    @JsonProperty("localTime")
    private String localTime;
    @JsonProperty("dateTime")
    private String dateTime;
    @JsonProperty("dateTBD")
    private Boolean dateTBD;
    @JsonProperty("dateTBA")
    private Boolean dateTBA;
    @JsonProperty("timeTBA")
    private Boolean timeTBA;
    @JsonProperty("noSpecificTime")
    private Boolean noSpecificTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("localDate")
    public String getLocalDate() {
        return localDate;
    }

    @JsonProperty("localDate")
    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    @JsonProperty("localTime")
    public String getLocalTime() {
        return localTime;
    }

    @JsonProperty("localTime")
    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    @JsonProperty("dateTime")
    public String getDateTime() {
        return dateTime;
    }

    @JsonProperty("dateTime")
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @JsonProperty("dateTBD")
    public Boolean getDateTBD() {
        return dateTBD;
    }

    @JsonProperty("dateTBD")
    public void setDateTBD(Boolean dateTBD) {
        this.dateTBD = dateTBD;
    }

    @JsonProperty("dateTBA")
    public Boolean getDateTBA() {
        return dateTBA;
    }

    @JsonProperty("dateTBA")
    public void setDateTBA(Boolean dateTBA) {
        this.dateTBA = dateTBA;
    }

    @JsonProperty("timeTBA")
    public Boolean getTimeTBA() {
        return timeTBA;
    }

    @JsonProperty("timeTBA")
    public void setTimeTBA(Boolean timeTBA) {
        this.timeTBA = timeTBA;
    }

    @JsonProperty("noSpecificTime")
    public Boolean getNoSpecificTime() {
        return noSpecificTime;
    }

    @JsonProperty("noSpecificTime")
    public void setNoSpecificTime(Boolean noSpecificTime) {
        this.noSpecificTime = noSpecificTime;
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
