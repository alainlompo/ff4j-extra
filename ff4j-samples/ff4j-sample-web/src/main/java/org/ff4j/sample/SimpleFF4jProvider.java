package org.ff4j.sample;

import static org.ff4j.audit.EventConstants.ACTION_CHECK_OK;
import static org.ff4j.audit.EventConstants.SOURCE_JAVA;
import static org.ff4j.audit.EventConstants.TARGET_FEATURE;

import java.util.ArrayList;
import java.util.List;

/*
 * #%L
 * ff4j-sample-web
 * %%
 * Copyright (C) 2013 - 2016 FF4J
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import org.ff4j.FF4j;
import org.ff4j.audit.Event;
import org.ff4j.audit.repository.EventRepository;
import org.ff4j.core.Feature;
import org.ff4j.utils.TimeUtils;
import org.ff4j.utils.Util;
import org.ff4j.web.FF4JProvider;

public class SimpleFF4jProvider implements FF4JProvider {

    /** ff4j instance. */
    private final FF4j ff4j;
    
    // Utility to generate event
    protected Event generateFeatureUsageEvent(String uid) {
        return new Event(SOURCE_JAVA, TARGET_FEATURE, uid, ACTION_CHECK_OK);
    }
    
    // Generate a random event during the period
    protected Event generateFeatureUsageEvent(String uid, long timestamp) {
        Event event = generateFeatureUsageEvent(uid);
        event.setTimestamp(timestamp);
        return event;
    }
    
    // Generate a random event during the period
    protected Event generateFeatureUsageEvent(String uid, long from, long to) {
        return generateFeatureUsageEvent(uid, from + (long) (Math.random() * (to-from)));
    }
    
    // Generate a random event during the period
    protected Event generateRandomFeatureUsageEvent(List < Feature > features, long from, long to) {
        return generateFeatureUsageEvent(Util.getRandomElement(features).getUid(), from , to);
    }
    
    // Populate repository for test
    protected void populateRepository(FF4j ff4j, int totalEvent) {
        EventRepository repo      = ff4j.getEventRepository(); 
        List < Feature > features = new ArrayList<Feature>(ff4j.getFeatures().values());
        for (int i = 0; i < totalEvent; i++) {
            repo.saveEvent(generateRandomFeatureUsageEvent(features,
                    TimeUtils.getTodayMidnightTime(), 
                    TimeUtils.getTomorrowMidnightTime()));
        }
    }

    /**
     * Default constructeur invoked by servlet.
     */
    public SimpleFF4jProvider() {
        ff4j = new FF4j("ff4j.xml").audit(true);
        // Create data for today
        populateRepository(ff4j, 100);
    }

    /**
     * Getter accessor for attribute 'fF4j'.
     *
     * @return current value of 'fF4j'
     */
    @Override
    public FF4j getFF4j() {
        return ff4j;
    }

}
