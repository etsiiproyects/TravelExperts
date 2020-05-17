
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
    "type",
    "subType",
    "family"
})
public class Classification_ {

    @JsonProperty("primary")
    private Boolean primary;
    @JsonProperty("segment")
    private Segment_ segment;
    @JsonProperty("genre")
    private Genre_ genre;
    @JsonProperty("subGenre")
    private SubGenre_ subGenre;
    @JsonProperty("type")
    private Type type;
    @JsonProperty("subType")
    private SubType subType;
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
    public Segment_ getSegment() {
        return segment;
    }

    @JsonProperty("segment")
    public void setSegment(Segment_ segment) {
        this.segment = segment;
    }

    @JsonProperty("genre")
    public Genre_ getGenre() {
        return genre;
    }

    @JsonProperty("genre")
    public void setGenre(Genre_ genre) {
        this.genre = genre;
    }

    @JsonProperty("subGenre")
    public SubGenre_ getSubGenre() {
        return subGenre;
    }

    @JsonProperty("subGenre")
    public void setSubGenre(SubGenre_ subGenre) {
        this.subGenre = subGenre;
    }

    @JsonProperty("type")
    public Type getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(Type type) {
        this.type = type;
    }

    @JsonProperty("subType")
    public SubType getSubType() {
        return subType;
    }

    @JsonProperty("subType")
    public void setSubType(SubType subType) {
        this.subType = subType;
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
