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

package com.cognizant.dashboard.collectors.github.db.repo;

import com.cognizant.dashboard.collectors.github.beans.repos.GitHubRepos;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.*;

/**
 * GitHubRepoRepository
 * @author Cognizant
 */

public interface GitHubRepoRepository extends MongoRepository<GitHubRepos, String> {

    Optional<GitHubRepos> findByFullName(String fullName);

}
