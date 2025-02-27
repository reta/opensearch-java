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

package org.opensearch.client.opensearch._types.aggregations;

import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.UnionDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.TaggedUnion;
import org.opensearch.client.util.TaggedUnionUtils;
import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

// typedef: _types.aggregations.TermsExclude


@JsonpDeserializable
public class TermsExclude implements TaggedUnion<TermsExclude.Kind, Object>, JsonpSerializable {

	public enum Kind {
		Terms, Regexp

	}

	private final Kind _kind;
	private final Object _value;

	@Override
	public final Kind _kind() {
		return _kind;
	}

	@Override
	public final Object _get() {
		return _value;
	}

	private TermsExclude(Kind kind, Object value) {
		this._kind = kind;
		this._value = value;
	}

	public String _toJsonString() {
		switch (_kind) {
			case Terms :
				return this.terms().stream().map(v -> v).collect(Collectors.joining(","));
			case Regexp :
				return this.regexp();

			default :
				throw new IllegalStateException("Unknown kind " + _kind);
		}
	}

	private TermsExclude(Builder builder) {

		this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
		this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");

	}

	public static TermsExclude of(Function<Builder, ObjectBuilder<TermsExclude>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Is this variant instance of kind {@code terms}?
	 */
	public boolean isTerms() {
		return _kind == Kind.Terms;
	}

	/**
	 * Get the {@code terms} variant value.
	 *
	 * @throws IllegalStateException
	 *             if the current variant is not of the {@code terms} kind.
	 */
	public List<String> terms() {
		return TaggedUnionUtils.get(this, Kind.Terms);
	}

	/**
	 * Is this variant instance of kind {@code regexp}?
	 */
	public boolean isRegexp() {
		return _kind == Kind.Regexp;
	}

	/**
	 * Get the {@code regexp} variant value.
	 *
	 * @throws IllegalStateException
	 *             if the current variant is not of the {@code regexp} kind.
	 */
	public String regexp() {
		return TaggedUnionUtils.get(this, Kind.Regexp);
	}

	@Override
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {
		if (_value instanceof JsonpSerializable) {
			((JsonpSerializable) _value).serialize(generator, mapper);
		} else {
			switch (_kind) {
				case Terms :
					generator.writeStartArray();
					for (String item0 : ((List<String>) this._value)) {
						generator.write(item0);

					}
					generator.writeEnd();

					break;
				case Regexp :
					generator.write(((String) this._value));

					break;
			}
		}

	}

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<TermsExclude> {
		private Kind _kind;
		private Object _value;

		public ObjectBuilder<TermsExclude> terms(List<String> v) {
			this._kind = Kind.Terms;
			this._value = v;
			return this;
		}

		public ObjectBuilder<TermsExclude> regexp(String v) {
			this._kind = Kind.Regexp;
			this._value = v;
			return this;
		}

		public TermsExclude build() {
			_checkSingleUse();
			return new TermsExclude(this);
		}

	}

	private static JsonpDeserializer<TermsExclude> buildTermsExcludeDeserializer() {
		return new UnionDeserializer.Builder<TermsExclude, Kind, Object>(TermsExclude::new, false)
				.addMember(Kind.Terms, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()))
				.addMember(Kind.Regexp, JsonpDeserializer.stringDeserializer()).build();
	}

	public static final JsonpDeserializer<TermsExclude> _DESERIALIZER = JsonpDeserializer
			.lazy(TermsExclude::buildTermsExcludeDeserializer);
}
