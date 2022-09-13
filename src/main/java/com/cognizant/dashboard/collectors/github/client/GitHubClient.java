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

package com.cognizant.dashboard.collectors.github.client;


import com.cognizant.dashboard.collectors.github.beans.branch.GitHubBranch;
import com.cognizant.dashboard.collectors.github.beans.commits.Commits;
import com.cognizant.dashboard.collectors.github.beans.pullrequest.PullRequest;
import com.cognizant.dashboard.collectors.github.beans.repos.GitHubRepos;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
/**
 * GitHubClient
 * @author Cognizant
 */

public interface GitHubClient {

        @GetMapping("/user/repos") // type = member, Default type=all
        List<GitHubRepos> getRepositories(@RequestHeader HttpHeaders requestHeader);

        @GetMapping("/repos/{ownerName}/{projectName}/branches")
        List<GitHubBranch> getBranches(@PathVariable("ownerName") Object ownerName,
                                       @PathVariable("projectName") Object projectName,
                                       @RequestHeader HttpHeaders requestHeader);

        ///repos/:owner/:repo/commits?since=YYYY-MM-DDTHH:MM:SSZ&until=YYYY-MM-DDTHH:MM:SSZ
        @GetMapping("/repos/{ownerName}/{projectName}/commits/{shaId}")
        Commits getCommits(@PathVariable("ownerName") Object ownerName,
                           @PathVariable("projectName") Object projectName,
                           @PathVariable("shaId") Object shaId,
                           @RequestHeader HttpHeaders requestHeader);

        @GetMapping("/repos/{owner}/{repo}/commits")
        List<Commits> getAllCommits(@RequestParam Map<String, String> requestParams,
                                   @RequestParam("owner") String owner,
                                   @RequestParam("repo") String repo,
                                    @RequestHeader HttpHeaders requestHeader
                                );


        @GetMapping("/repos/{owner}/{repo}/pulls")
        List<PullRequest> getPullRequests(@RequestParam Map<String, String> requestParams,
                                          @RequestParam("owner") String owner,
                                          @RequestParam("repo") String repo,
                                          @RequestHeader HttpHeaders requestHeader);

}



