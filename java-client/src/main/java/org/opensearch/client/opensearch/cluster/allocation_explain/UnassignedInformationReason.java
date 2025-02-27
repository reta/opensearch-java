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

package org.opensearch.client.opensearch.cluster.allocation_explain;

import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;

@JsonpDeserializable
public enum UnassignedInformationReason implements JsonEnum {
	IndexCreated("INDEX_CREATED"),

	ClusterRecovered("CLUSTER_RECOVERED"),

	IndexReopened("INDEX_REOPENED"),

	DanglingIndexImported("DANGLING_INDEX_IMPORTED"),

	NewIndexRestored("NEW_INDEX_RESTORED"),

	ExistingIndexRestored("EXISTING_INDEX_RESTORED"),

	ReplicaAdded("REPLICA_ADDED"),

	AllocationFailed("ALLOCATION_FAILED"),

	NodeLeft("NODE_LEFT"),

	RerouteCancelled("REROUTE_CANCELLED"),

	Reinitialized("REINITIALIZED"),

	ReallocatedReplica("REALLOCATED_REPLICA"),

	PrimaryFailed("PRIMARY_FAILED"),

	ForcedEmptyPrimary("FORCED_EMPTY_PRIMARY"),

	ManualAllocation("MANUAL_ALLOCATION"),

	;

	private final String jsonValue;

	UnassignedInformationReason(String jsonValue) {
		this.jsonValue = jsonValue;
	}

	public String jsonValue() {
		return this.jsonValue;
	}

	public static final JsonEnum.Deserializer<UnassignedInformationReason> _DESERIALIZER = new JsonEnum.Deserializer<>(
			UnassignedInformationReason.values());
}
