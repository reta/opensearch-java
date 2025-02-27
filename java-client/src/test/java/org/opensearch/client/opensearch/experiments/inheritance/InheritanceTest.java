/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

package org.opensearch.client.opensearch.experiments.inheritance;

import org.junit.Test;
import org.opensearch.client.opensearch.experiments.inheritance.child.ChildClass;
import org.opensearch.client.opensearch.experiments.inheritance.final_.FinalClass;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class InheritanceTest extends ModelTestCase {

    @Test
    public void testSerialization() {

        FinalClass fc = new FinalClass.Builder()
            // Start fields from the top of the hierarchy to test setter return values
            .baseField("baseValue")
            .childField("childValue")
            .finalField("finalValue")
            .build();

        String str = toJson(fc);

        assertEquals("{\"baseField\":\"baseValue\",\"childField\":\"childValue\",\"finalField\":\"finalValue\"}", str);

        ChildClass cc = new ChildClass.Builder()
            // Start fields from the top of the hierarchy to test setter return values
            .baseField("baseValue")
            .childField("childValue")
            .build();

        str = toJson(cc);

        assertEquals("{\"baseField\":\"baseValue\",\"childField\":\"childValue\"}", str);
    }

    @Test
    public void testDeserialization() {

        String json = "{\"baseField\":\"baseValue\",\"childField\":\"childValue\",\"finalField\":\"finalValue\"}";

        FinalClass fc = fromJson(json, FinalClass.JSONP_PARSER);

        assertEquals("baseValue", fc.baseField());
        assertEquals("childValue", fc.childField());
        assertEquals("finalValue", fc.finalField());


        json = "{\"baseField\":\"baseValue\",\"childField\":\"childValue\"}";

        ChildClass cc = fromJson(json, ChildClass.JSONP_PARSER);

        assertEquals("baseValue", cc.baseField());
        assertEquals("childValue", cc.childField());
    }
}
