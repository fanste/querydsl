/*
 * Copyright 2011, Mysema Ltd
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mysema.query.jpa.hibernate;

import java.util.List;

import org.hibernate.transform.ResultTransformer;

import com.mysema.query.types.FactoryExpression;

/**
 * FactoryExpressionTransformer is a ResultTransformer implementation using the EConstructor for transformation
 * 
 * @author tiwe
 *
 */
public final class FactoryExpressionTransformer implements ResultTransformer {

    private static final long serialVersionUID = -3625957233853100239L;

    private final transient FactoryExpression<?> constructor;

    public FactoryExpressionTransformer(FactoryExpression<?> constructor){
        this.constructor = constructor;
    }

    @Override
    public List transformList(List collection) {
        return collection;
    }

    @Override
    public Object transformTuple(Object[] tuple, String[] aliases) {
        return constructor.newInstance(tuple);
    }

}
