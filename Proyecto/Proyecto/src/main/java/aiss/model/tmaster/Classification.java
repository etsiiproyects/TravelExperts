
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
    "primary",
    "segment",
    "genre",
    "subGenre",
    "family"
})
public class Classification {

    @JsonProperty("primary")
    private Boolean primary;
    @JsonProperty("segment")
    private Segment segment;
    @JsonProperty("genre")
    private Genre genre;
    @JsonProperty("subGenre")
    private SubGenre subGenre;
    @JsonProperty("family")
    private Boolean family;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("primary")
    public Boolean getPrimary() {
        return primary;
    }

    @JsonProperty("primary")
    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    @JsonProperty("segment")
    public Segment getSegment() {
        return segment;
    }

    @JsonProperty("segment")
    public void setSegment(Segment segment) {
        this.segment = segment;
    }

    @JsonProperty("genre")
    public Genre getGenre() {
        return genre;
    }

    @JsonProperty("genre")
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @JsonProperty("subGenre")
    public SubGenre getSubGenre() {
        return subGenre;
    }

    @JsonProperty("subGenre")
    public void setSubGenre(SubGenre subGenre) {
        this.subGenre = subGenre;
    }

    @JsonProperty("family")
    public Boolean getFamily() {
        return family;
    }

    @JsonProperty("family")
    public void setFamily(Boolean family) {
        this.family = family;
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
