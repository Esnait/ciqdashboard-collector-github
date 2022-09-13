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

package com.cognizant.dashboard.collectors.github.service;

import com.cognizant.dashboard.collectors.github.beans.repos.GitHubRepos;
import com.cognizant.dashboard.collectors.github.db.repo.CustomRepository;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.commons.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
/**
 * GitHubDataService
 * @author Cognizant
 */

@Service
@Slf4j
public class GitHubDataService {
    @Autowired
    CustomRepository customRepository;

    public String getLastCommitDate(String projectName) {
        String since = "";
        List<GitHubRepos> lastCommittedDateQuery = customRepository.findLastCommittedDateQuery(projectName);
        if (!CollectionUtils.isEmpty(lastCommittedDateQuery)) {

            if(!CollectionUtils.isEmpty(lastCommittedDateQuery.get(0).getCommitsList())) {
                since = lastCommittedDateQuery.get(0).getCommitsList().get(0).getCommit().getCommitter().getDate().toInstant().toString();
            }
        }
        log.info("Since Date is: {}", since);
        return since;
    }

}
