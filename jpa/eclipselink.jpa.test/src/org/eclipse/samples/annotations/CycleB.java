/*******************************************************************************
 * Copyright (c) 2018 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     06/206/2018-2.7.2 Tomas Kraus
 *       - 535250: Test meta-annotations with dependency cycle
 ******************************************************************************/
package org.eclipse.samples.annotations;

@CycleC
public @interface CycleB {
}