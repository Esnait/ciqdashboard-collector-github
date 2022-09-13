/*
 * © [2021] Cognizant. All rights reserved.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.cognizant.dashboard.collectors.github.beans.commits;

import com.cognizant.dashboard.collectors.github.beans.branch.GitHubBranch;
import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Commits
 * @author Cognizant
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "sha",
        "node_id",
        "commit",
        "url",
        "html_url",
        "comments_url",
        "author",
        "committer",
        "parents",
        "stats",
        "files",
        "projectId",
        "projectName",
        "branchName"
})
@Data
public class Commits {

    @JsonProperty("sha")
    public String sha;
    @JsonProperty("node_id")
    public String nodeId;
    @JsonProperty("commit")
    public Commit commit;
    @JsonProperty("url")
    public String url;
    @JsonProperty("html_url")
    public String htmlUrl;
    @JsonProperty("comments_url")
    public String commentsUrl;
    @JsonProperty("author")
    public Author author;
    @JsonProperty("committer")
    public CommitterDetails committer;
    @JsonProperty("parents")
    public List<Object> parents = null;
    @JsonProperty("stats")
    public Stats stats;
    @JsonProperty("files")
    public List<Files> files = null;
    @JsonProperty("projectId")
    public String projectId;
    @JsonProperty("projectName")
    public String projectName;
    @JsonProperty("branchName")
    public String branchName;
    private List<GitHubBranch> branches=null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

