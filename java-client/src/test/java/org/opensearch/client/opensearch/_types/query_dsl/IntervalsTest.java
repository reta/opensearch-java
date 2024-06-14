/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class IntervalsTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        Intervals origin = new Intervals.Builder().match(new IntervalsMatch.Builder().query("query").build()).build();
        Intervals copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
