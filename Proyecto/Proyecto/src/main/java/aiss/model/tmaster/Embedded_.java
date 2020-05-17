
package aiss.model.tmaster;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "venues",
    "attractions"
})
public class Embedded_ {

    @JsonProperty("venues")
    private List<Venue_> venues = null;
    @JsonProperty("attractions")
    private List<Attraction_> attractions = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("venues")
    public List<Venue_> getVenues() {
        return venues;
    }

    @JsonProperty("venues")
    public void setVenues(List<Venue_> venues) {
        this.venues = venues;
    }

    @JsonProperty("attractions")
    public List<Attraction_> getAttractions() {
        return attractions;
    }

    @JsonProperty("attractions")
    public void setAttractions(List<Attraction_> attractions) {
        this.attractions = attractions;
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
