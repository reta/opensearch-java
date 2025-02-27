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

package org.opensearch.client.opensearch.core.rank_eval;

import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: _global.rank_eval.RankEvalMetricDiscountedCumulativeGain

/**
 * Discounted cumulative gain (DCG)
 * 
 */
@JsonpDeserializable
public class RankEvalMetricDiscountedCumulativeGain extends RankEvalMetricBase {
	@Nullable
	private final Boolean normalize;

	// ---------------------------------------------------------------------------------------------

	private RankEvalMetricDiscountedCumulativeGain(Builder builder) {
		super(builder);

		this.normalize = builder.normalize;

	}

	public static RankEvalMetricDiscountedCumulativeGain of(
			Function<Builder, ObjectBuilder<RankEvalMetricDiscountedCumulativeGain>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * If set to true, this metric will calculate the Normalized DCG.
	 * <p>
	 * API name: {@code normalize}
	 */
	@Nullable
	public final Boolean normalize() {
		return this.normalize;
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		super.serializeInternal(generator, mapper);
		if (this.normalize != null) {
			generator.writeKey("normalize");
			generator.write(this.normalize);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link RankEvalMetricDiscountedCumulativeGain}.
	 */

	public static class Builder extends RankEvalMetricBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<RankEvalMetricDiscountedCumulativeGain> {
		@Nullable
		private Boolean normalize;

		/**
		 * If set to true, this metric will calculate the Normalized DCG.
		 * <p>
		 * API name: {@code normalize}
		 */
		public final Builder normalize(@Nullable Boolean value) {
			this.normalize = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link RankEvalMetricDiscountedCumulativeGain}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public RankEvalMetricDiscountedCumulativeGain build() {
			_checkSingleUse();

			return new RankEvalMetricDiscountedCumulativeGain(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link RankEvalMetricDiscountedCumulativeGain}
	 */
	public static final JsonpDeserializer<RankEvalMetricDiscountedCumulativeGain> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new,
					RankEvalMetricDiscountedCumulativeGain::setupRankEvalMetricDiscountedCumulativeGainDeserializer);

	protected static void setupRankEvalMetricDiscountedCumulativeGainDeserializer(
			ObjectDeserializer<RankEvalMetricDiscountedCumulativeGain.Builder> op) {
		setupRankEvalMetricBaseDeserializer(op);
		op.add(Builder::normalize, JsonpDeserializer.booleanDeserializer(), "normalize");

	}

}
