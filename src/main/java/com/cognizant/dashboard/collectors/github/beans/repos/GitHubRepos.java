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

package com.cognizant.dashboard.collectors.github.beans.repos;

import com.cognizant.dashboard.collectors.github.beans.commits.Commits;
import com.cognizant.dashboard.collectors.github.beans.pullrequest.PullRequest;
import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * GitHubRepos - refers to collection
 * @author Cognizant
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "node_id",
        "name",
        "full_name",
        "private",
        "owner",
        "html_url",
        "description",
        "fork",
        "url",
        "forks_url",
        "keys_url",
        "collaborators_url",
        "teams_url",
        "hooks_url",
        "issue_events_url",
        "events_url",
        "assignees_url",
        "branches_url",
        "tags_url",
        "blobs_url",
        "git_tags_url",
        "git_refs_url",
        "trees_url",
        "statuses_url",
        "languages_url",
        "stargazers_url",
        "contributors_url",
        "subscribers_url",
        "subscription_url",
        "commits_url",
        "git_commits_url",
        "comments_url",
        "issue_comment_url",
        "contents_url",
        "compare_url",
        "merges_url",
        "archive_url",
        "downloads_url",
        "issues_url",
        "pulls_url",
        "milestones_url",
        "notifications_url",
        "labels_url",
        "releases_url",
        "deployments_url",
        "created_at",
        "updated_at",
        "pushed_at",
        "git_url",
        "ssh_url",
        "clone_url",
        "svn_url",
        "homepage",
        "size",
        "stargazers_count",
        "watchers_count",
        "language",
        "has_issues",
        "has_projects",
        "has_downloads",
        "has_wiki",
        "has_pages",
        "forks_count",
        "mirror_url",
        "archived",
        "disabled",
        "open_issues_count",
        "license",
        "forks",
        "open_issues",
        "watchers",
        "default_branch",
        "permissions"
})
@Data
@Document(collection = "#{T(com.cognizant.dashboard.collectors.github.component.GitHubComponent).getCollectionName()}")
public class GitHubRepos {

    @Id
    private @Getter @Setter String objectId;
    @JsonProperty("id")
    private Integer projectId;
    @JsonProperty("node_id")
    private String nodeId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("private")
    private Boolean _private;
    @JsonProperty("owner")
    private Owner owner;
    @Transient
    @JsonProperty("html_url")
    private String htmlUrl;
    @JsonProperty("description")
    private Object description;
    @JsonProperty("fork")
    private Boolean fork;
    @JsonProperty("url")
    private String url;
    @Transient
    @JsonProperty("forks_url")
    private String forksUrl;
    @Transient
    @JsonProperty("keys_url")
    private String keysUrl;
    @Transient
    @JsonProperty("collaborators_url")
    private String collaboratorsUrl;
    @Transient
    @JsonProperty("teams_url")
    private String teamsUrl;
    @Transient
    @JsonProperty("hooks_url")
    private String hooksUrl;
    @Transient
    @JsonProperty("issue_events_url")
    private String issueEventsUrl;
    @Transient
    @JsonProperty("events_url")
    private String eventsUrl;
    @Transient
    @JsonProperty("assignees_url")
    private String assigneesUrl;
    @Transient
    @JsonProperty("branches_url")
    private String branchesUrl;
    @Transient
    @JsonProperty("tags_url")
    private String tagsUrl;
    @Transient
    @JsonProperty("blobs_url")
    private String blobsUrl;
    @Transient
    @JsonProperty("git_tags_url")
    private String gitTagsUrl;
    @Transient
    @JsonProperty("git_refs_url")
    private String gitRefsUrl;
    @Transient
    @JsonProperty("trees_url")
    private String treesUrl;
    @Transient
    @JsonProperty("statuses_url")
    private String statusesUrl;
    @Transient
    @JsonProperty("languages_url")
    private String languagesUrl;
    @Transient
    @JsonProperty("stargazers_url")
    private String stargazersUrl;
    @Transient
    @JsonProperty("contributors_url")
    private String contributorsUrl;
    @Transient
    @JsonProperty("subscribers_url")
    private String subscribersUrl;
    @Transient
    @JsonProperty("subscription_url")
    private String subscriptionUrl;
    @Transient
    @JsonProperty("commits_url")
    private String commitsUrl;
    @Transient
    @JsonProperty("git_commits_url")
    private String gitCommitsUrl;
    @Transient
    @JsonProperty("comments_url")
    private String commentsUrl;
    @Transient
    @JsonProperty("issue_comment_url")
    private String issueCommentUrl;
    @Transient
    @JsonProperty("contents_url")
    private String contentsUrl;
    @Transient
    @JsonProperty("compare_url")
    private String compareUrl;
    @Transient
    @JsonProperty("merges_url")
    private String mergesUrl;
    @Transient
    @JsonProperty("archive_url")
    private String archiveUrl;
    @Transient
    @JsonProperty("downloads_url")
    private String downloadsUrl;
    @Transient
    @JsonProperty("issues_url")
    private String issuesUrl;
    @Transient
    @JsonProperty("pulls_url")
    private String pullsUrl;
    @Transient
    @JsonProperty("milestones_url")
    private String milestonesUrl;
    @Transient
    @JsonProperty("notifications_url")
    private String notificationsUrl;
    @Transient
    @JsonProperty("labels_url")
    private String labelsUrl;
    @Transient
    @JsonProperty("releases_url")
    private String releasesUrl;
    @Transient
    @JsonProperty("deployments_url")
    private String deploymentsUrl;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("pushed_at")
    private String pushedAt;
    @Transient
    @JsonProperty("git_url")
    private String gitUrl;
    @Transient
    @JsonProperty("ssh_url")
    private String sshUrl;
    @Transient
    @JsonProperty("clone_url")
    private String cloneUrl;
    @Transient
    @JsonProperty("svn_url")
    private String svnUrl;
    @Transient
    @JsonProperty("homepage")
    private Object homepage;
    @JsonProperty("size")
    private Integer size;
    @JsonProperty("stargazers_count")
    private Integer stargazersCount;
    @JsonProperty("watchers_count")
    private Integer watchersCount;
    @JsonProperty("language")
    private Object language;
    @JsonProperty("has_issues")
    private Boolean hasIssues;
    @JsonProperty("has_projects")
    private Boolean hasProjects;
    @JsonProperty("has_downloads")
    private Boolean hasDownloads;
    @JsonProperty("has_wiki")
    private Boolean hasWiki;
    @JsonProperty("has_pages")
    private Boolean hasPages;
    @JsonProperty("forks_count")
    private Integer forksCount;
    @Transient
    @JsonProperty("mirror_url")
    private Object mirrorUrl;
    @Transient
    @JsonProperty("archived")
    private Boolean archived;
    @JsonProperty("disabled")
    private Boolean disabled;
    @JsonProperty("open_issues_count")
    private Integer openIssuesCount;
    @Transient
    @JsonProperty("license")
    private Object license;
    @JsonProperty("forks")
    private Integer forks;
    @JsonProperty("open_issues")
    private Integer openIssues;
    @JsonProperty("watchers")
    private Integer watchers;
    @JsonProperty("default_branch")
    private String defaultBranch;
    @Transient
    @JsonProperty("permissions")
    private Permissions permissions;

    private List<Commits> commitsList=null;
    private List<PullRequest> pullRequests=null;
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


