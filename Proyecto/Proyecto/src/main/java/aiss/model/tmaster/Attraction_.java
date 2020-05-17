
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
    "name",
    "type",
    "id",
    "test",
    "url",
    "locale",
    "images",
    "classifications",
    "upcomingEvents",
    "_links"
})
public class Attraction_ {

    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("id")
    private String id;
    @JsonProperty("test")
    private Boolean test;
    @JsonProperty("url")
    private String url;
    @JsonProperty("locale")
    private String locale;
    @JsonProperty("images")
    private List<Image_> images = null;
    @JsonProperty("classifications")
    private List<Classification_> classifications = null;
    @JsonProperty("upcomingEvents")
    private UpcomingEvents_ upcomingEvents;
    @JsonProperty("_links")
    private Links__ links;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("test")
    public Boolean getTest() {
        return test;
    }

    @JsonProperty("test")
    public void setTest(Boolean test) {
        this.test = test;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("locale")
    public String getLocale() {
        return locale;
    }

    @JsonProperty("locale")
    public void setLocale(String locale) {
        this.locale = locale;
    }

    @JsonProperty("images")
    public List<Image_> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(List<Image_> images) {
        this.images = images;
    }

    @JsonProperty("classifications")
    public List<Classification_> getClassifications() {
        return classifications;
    }

    @JsonProperty("classifications")
    public void setClassifications(List<Classification_> classifications) {
        this.classifications = classifications;
    }

    @JsonProperty("upcomingEvents")
    public UpcomingEvents_ getUpcomingEvents() {
        return upcomingEvents;
    }

    @JsonProperty("upcomingEvents")
    public void setUpcomingEvents(UpcomingEvents_ upcomingEvents) {
        this.upcomingEvents = upcomingEvents;
    }

    @JsonProperty("_links")
    public Links__ getLinks() {
        return links;
    }

    @JsonProperty("_links")
    public void setLinks(Links__ links) {
        this.links = links;
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
