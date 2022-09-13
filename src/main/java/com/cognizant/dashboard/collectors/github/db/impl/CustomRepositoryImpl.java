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

package com.cognizant.dashboard.collectors.github.db.impl;

import com.cognizant.dashboard.collectors.github.beans.repos.GitHubRepos;
import com.cognizant.dashboard.collectors.github.db.repo.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.*;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * CustomRepositoryImpl
 * @author Cognizant
 */

@Repository
public class CustomRepositoryImpl implements CustomRepository {

    private MongoTemplate template;
    @Autowired
    public CustomRepositoryImpl(MongoTemplate mongoTemplate) {
        this.template = mongoTemplate;
    }

    @Override
    public List<GitHubRepos> findLastCommittedDateQuery(String projectName) {
        return findByFieldInOrder(projectName, Sort.Direction.DESC, "commit.committer.date");
    }

    private List<GitHubRepos> findByFieldInOrder(String projectName, Sort.Direction direction, String fieldName){
        Query query = new Query();
        Criteria criteria = Criteria.where("name").is(projectName);

        query.addCriteria(criteria);
        query.with(Sort.by(direction, fieldName));

        return template.find(query, GitHubRepos.class);

    }






}
