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

package com.cognizant.dashboard.collectors.github.beans.pullrequest;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cognizant.dashboard.collectors.github.beans.repos.Owner;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
/**
 * PullRequest
 * @author Cognizant
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "url",
        "id",
        "node_id",
        "html_url",
        "diff_url",
        "patch_url",
        "issue_url",
        "number",
        "state",
        "locked",
        "title",
        "user",
        "body",
        "created_at",
        "updated_at",
        "closed_at",
        "merged_at",
        "merge_commit_sha",
        "assignee",
        "assignees",
        "requested_reviewers",
        "requested_teams",
        "labels",
        "milestone",
        "draft",
        "commits_url",
        "review_comments_url",
        "review_comment_url",
        "comments_url",
        "statuses_url",
        "head",
        "base",
        "_links",
        "author_association",
        "active_lock_reason"
})
public class PullRequest {

    @JsonProperty("url")
    public String url;
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("node_id")
    public String nodeId;
    @JsonProperty("html_url")
    public String htmlUrl;
    @JsonProperty("diff_url")
    public String diffUrl;
    @JsonProperty("patch_url")
    public String patchUrl;
    @JsonProperty("issue_url")
    public String issueUrl;
    @JsonProperty("number")
    public Integer number;
    @JsonProperty("state")
    public String state;
    @JsonProperty("locked")
    public Boolean locked;
    @JsonProperty("title")
    public String title;
    @JsonProperty("user")
    public Owner user;
    @JsonProperty("body")
    public String body;
    @JsonProperty("created_at")
    public String createdAt;
    @JsonProperty("updated_at")
    public String updatedAt;
    @JsonProperty("closed_at")
    public Object closedAt;
    @JsonProperty("merged_at")
    public Object mergedAt;
    @JsonProperty("merge_commit_sha")
    public String mergeCommitSha;
    @JsonProperty("assignee")
    public Object assignee;
    @JsonProperty("assignees")
    public List<Object> assignees = null;
    @JsonProperty("requested_reviewers")
    public List<Object> requestedReviewers = null;
    @JsonProperty("requested_teams")
    public List<Object> requestedTeams = null;
    @JsonProperty("labels")
    public List<Object> labels = null;
    @JsonProperty("milestone")
    public Object milestone;
    @JsonProperty("draft")
    public Boolean draft;
    @JsonProperty("commits_url")
    public String commitsUrl;
    @JsonProperty("review_comments_url")
    public String reviewCommentsUrl;
    @JsonProperty("review_comment_url")
    public String reviewCommentUrl;
    @JsonProperty("comments_url")
    public String commentsUrl;
    @JsonProperty("statuses_url")
    public String statusesUrl;
    @JsonProperty("head")
    public Head head;
    @JsonProperty("base")
    public Base base;
    @JsonProperty("_links")
    public Links links;
    @JsonProperty("author_association")
    public String authorAssociation;
    @JsonProperty("active_lock_reason")
    public Object activeLockReason;
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
