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

package com.cognizant.dashboard.collectors.github.component;

import com.cognizant.dashboard.collectors.github.client.GitHubClient;
import com.cognizant.dashboard.collectors.github.constants.Constants;
import com.cognizant.dashboard.collectors.github.beans.commits.Commits;
import com.cognizant.dashboard.collectors.github.beans.pullrequest.PullRequest;
import com.cognizant.dashboard.collectors.github.beans.repos.GitHubRepos;
import com.cognizant.dashboard.collectors.github.db.repo.GitHubRepoRepository;
import com.cognizant.dashboard.collectors.github.service.GitHubDataService;
import feign.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

import static com.cognizant.dashboard.collectors.github.constants.Constants.SOURCE;
/**
 * GitHubComponent - Github method component
 * @author Cognizant
 */

@Component
@Slf4j
@RequiredArgsConstructor
public class GitHubComponent {

    private static String collectionName;
    @Autowired
    private GitHubClient gitHubClient;
    @Autowired
    private GitHubDataService gitHubDataService;
    @Autowired
    private GitHubRepoRepository gitHubRepoRepository;
    private HttpHeaders requestHeader = new HttpHeaders();
    @Autowired
    private  GithubCommonUtility commonUtility;
    @PostConstruct
    public HttpHeaders postConstructMethod(){
        return requestHeader = commonUtility.getHeaders();
    }

    public List<GitHubRepos> getRepos() {
        List<GitHubRepos> gitHubRepository = gitHubClient.getRepositories(requestHeader);
        return gitHubRepository;
    }

    List<Commits> updateCommits(String ownerName, String repoName, String since) {
        List<Commits> commitsList = new ArrayList<>();
        int pageIndex = 1;
        boolean hasMorePages = true;
        while (hasMorePages) {
            List<Commits> commits = getAllCommits(ownerName, repoName, pageIndex, since);
            commitsList.addAll(commits);
            if (commits.size() <= 0 || commits.size() < Constants.MAX_PER_PAGE_ITEMS) {
                hasMorePages = false;
                continue;
            }
            pageIndex++;
        }
        return commitsList;
    }

    List<Commits> getAllCommits(String ownerName, String repoName, int pageIndex, String since) {
        Map<String, String> requestParamMap = new HashMap();
        requestParamMap.put(Constants.PER_PAGE, String.valueOf(Constants.MAX_PER_PAGE_ITEMS));
        requestParamMap.put(Constants.PAGE, String.valueOf(pageIndex));
        requestParamMap.put(Constants.SINCE, since);

        List<Commits> commitsList;
        try {
            commitsList = gitHubClient.getAllCommits(requestParamMap, ownerName, repoName, requestHeader);
        }catch (FeignException e) {
            commitsList = new ArrayList<>();
        }
        commitsList.forEach(commits -> {
            Commits commitsDetails = gitHubClient.getCommits(ownerName, repoName,commits.getSha(),requestHeader);
            commits.setFiles(commitsDetails.getFiles());
            commits.setStats(commitsDetails.getStats());
        });

        return commitsList;
    }

    public void getGitHubReposData() {
        List<GitHubRepos> reposList = getRepos();
        reposList.forEach(repo -> {

            Optional<GitHubRepos> optional = gitHubRepoRepository.findByFullName(repo.getFullName());

            optional.ifPresent(gitHubRepos -> repo.setObjectId(gitHubRepos.getObjectId()));

            String lastCommitDate = gitHubDataService.getLastCommitDate(repo.getName());
            log.info("Collecting Commit Details for " + repo.getOwner().getLogin() + " " + repo.getName());
            List<Commits> commits = updateCommits(repo.getOwner().getLogin(), repo.getName(), lastCommitDate);
            repo.setCommitsList(commits);
            log.info("Collecting PullRequest Details for " + repo.getOwner().getLogin() + " " + repo.getName());
            List<PullRequest> pullRequestList = getPullRequest(repo.getOwner().getLogin(), repo.getName());
            repo.setPullRequests(pullRequestList);

        });
        gitHubRepoRepository.saveAll(reposList);
    }

    public List<PullRequest> getPullRequest(String owner, String repo) {
        List<PullRequest> allPullRequestList = new ArrayList<>();
        int pageIndex = 1;
        boolean hasMorePages = true;
        Map<String, String> requestParamMap = new HashMap();
        requestParamMap.put(Constants.PER_PAGE, String.valueOf(Constants.MAX_PER_PAGE_ITEMS));
        requestParamMap.put("state", "all");
        while (hasMorePages) {
            requestParamMap.put(Constants.PAGE, String.valueOf(pageIndex));
            List<PullRequest> pullRequestList = gitHubClient.getPullRequests(requestParamMap, owner, repo,requestHeader);
            allPullRequestList.addAll(pullRequestList);
            if (pullRequestList.size() <= 0 || pullRequestList.size() < Constants.MAX_PER_PAGE_ITEMS) {
                hasMorePages = false;
                continue;
            }
            pageIndex++;
        }
        return allPullRequestList;
    }

    @Value("${spring.data.mongodb.collection}")
    public void setCollectionName(String collectionNameVariable) {
        collectionName = SOURCE+collectionNameVariable;
    }

    public static String getCollectionName(){
        return collectionName;
    }
}
