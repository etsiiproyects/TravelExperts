
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
    "sales",
    "dates",
    "classifications",
    "promoter",
    "promoters",
    "_links",
    "_embedded"
})
public class Event {

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
    private List<Image> images = null;
    @JsonProperty("sales")
    private Sales sales;
    @JsonProperty("dates")
    private Dates dates;
    @JsonProperty("classifications")
    private List<Classification> classifications = null;
    @JsonProperty("promoter")
    private Promoter promoter;
    @JsonProperty("promoters")
    private List<Promoter_> promoters = null;
    @JsonProperty("_links")
    private Links links;
    @JsonProperty("_embedded")
    private Embedded_ embedded;
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
    public List<Image> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(List<Image> images) {
        this.images = images;
    }

    @JsonProperty("sales")
    public Sales getSales() {
        return sales;
    }

    @JsonProperty("sales")
    public void setSales(Sales sales) {
        this.sales = sales;
    }

    @JsonProperty("dates")
    public Dates getDates() {
        return dates;
    }

    @JsonProperty("dates")
    public void setDates(Dates dates) {
        this.dates = dates;
    }

    @JsonProperty("classifications")
    public List<Classification> getClassifications() {
        return classifications;
    }

    @JsonProperty("classifications")
    public void setClassifications(List<Classification> classifications) {
        this.classifications = classifications;
    }

    @JsonProperty("promoter")
    public Promoter getPromoter() {
        return promoter;
    }

    @JsonProperty("promoter")
    public void setPromoter(Promoter promoter) {
        this.promoter = promoter;
    }

    @JsonProperty("promoters")
    public List<Promoter_> getPromoters() {
        return promoters;
    }

    @JsonProperty("promoters")
    public void setPromoters(List<Promoter_> promoters) {
        this.promoters = promoters;
    }

    @JsonProperty("_links")
    public Links getLinks() {
        return links;
    }

    @JsonProperty("_links")
    public void setLinks(Links links) {
        this.links = links;
    }

    @JsonProperty("_embedded")
    public Embedded_ getEmbedded() {
        return embedded;
    }

    @JsonProperty("_embedded")
    public void setEmbedded(Embedded_ embedded) {
        this.embedded = embedded;
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
