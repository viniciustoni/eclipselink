/*
 * Copyright (c) 2006, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     Oracle - initial API and implementation
//
package org.eclipse.persistence.jpa.tests.jpql.parser;

import org.eclipse.persistence.jpa.jpql.parser.AggregateFunction;
import org.eclipse.persistence.jpa.jpql.parser.AvgFunction;
import static org.eclipse.persistence.jpa.tests.jpql.parser.JPQLParserTester.*;

/**
 * Unit-tests for {@link org.eclipse.persistence.jpa.jpql.parser.AvgFunction AvgFunction}.
 *
 * @version 2.5
 * @since 2.3
 * @author Pascal Filion
 */
public final class AvgFunctionTest extends AggregateFunctionTest {

    @Override
    protected AggregateFunctionTester aggregateFunctionTester(ExpressionTester expression) {
        return avg(expression);
    }

    @Override
    protected Class<? extends AggregateFunction> functionClass() {
        return AvgFunction.class;
    }

    @Override
    protected String identifier() {
        return AvgFunction.AVG;
    }
}
