
package aiss.model.gcalendar;

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
    "kind",
    "etag",
    "summary",
    "updated",
    "timeZone",
    "accessRole",
    "defaultReminders",
    "nextSyncToken",
    "items"
})
public class GCalendarSearch {

    @JsonProperty("kind")
    private String kind;
    @JsonProperty("etag")
    private String etag;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("updated")
    private String updated;
    @JsonProperty("timeZone")
    private String timeZone;
    @JsonProperty("accessRole")
    private String accessRole;
    @JsonProperty("defaultReminders")
    private List<DefaultReminder> defaultReminders = null;
    @JsonProperty("nextSyncToken")
    private String nextSyncToken;
    @JsonProperty("items")
    private List<Item> items = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("etag")
    public String getEtag() {
        return etag;
    }

    @JsonProperty("etag")
    public void setEtag(String etag) {
        this.etag = etag;
    }

    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @JsonProperty("updated")
    public String getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @JsonProperty("timeZone")
    public String getTimeZone() {
        return timeZone;
    }

    @JsonProperty("timeZone")
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @JsonProperty("accessRole")
    public String getAccessRole() {
        return accessRole;
    }

    @JsonProperty("accessRole")
    public void setAccessRole(String accessRole) {
        this.accessRole = accessRole;
    }

    @JsonProperty("defaultReminders")
    public List<DefaultReminder> getDefaultReminders() {
        return defaultReminders;
    }

    @JsonProperty("defaultReminders")
    public void setDefaultReminders(List<DefaultReminder> defaultReminders) {
        this.defaultReminders = defaultReminders;
    }

    @JsonProperty("nextSyncToken")
    public String getNextSyncToken() {
        return nextSyncToken;
    }

    @JsonProperty("nextSyncToken")
    public void setNextSyncToken(String nextSyncToken) {
        this.nextSyncToken = nextSyncToken;
    }

    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
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
