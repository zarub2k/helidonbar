/*
 * Copyright (c) 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hustlebar.helidonbar;

import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.hustlebar.helidonbar.core.HelidonbarExceptionMapper;
import com.hustlebar.helidonbar.country.CountryApi;
import com.hustlebar.helidonbar.restclient.CalculatorApi;
import com.hustlebar.helidonbar.tolerance.HelidonbarFaultToleranceApi;
import com.hustlebar.helidonbar.ping.PingApi;
import io.helidon.common.CollectionsHelper;

/**
 * Helidonbar Application.
 */
@ApplicationScoped
@ApplicationPath("/")
public class HelidonbarApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();

        classes.addAll(addResources());
        classes.addAll(addProviders());
        return classes;
    }

    private Set<Class<?>> addResources() {
        return CollectionsHelper.setOf(
                GreetResource.class,
                PingApi.class,
                CountryApi.class,
                HelidonbarFaultToleranceApi.class,
                CalculatorApi.class
        );
    }

    private Set<Class<?>> addProviders() {
        return CollectionsHelper.setOf(
                HelidonbarExceptionMapper.class
        );
    }
}
