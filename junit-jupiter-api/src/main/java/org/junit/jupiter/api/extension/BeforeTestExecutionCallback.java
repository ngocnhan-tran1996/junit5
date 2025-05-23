/*
 * Copyright 2015-2025 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * https://www.eclipse.org/legal/epl-v20.html
 */

package org.junit.jupiter.api.extension;

import static org.apiguardian.api.API.Status.STABLE;

import org.apiguardian.api.API;

/**
 * {@code BeforeTestExecutionCallback} defines the API for {@link Extension
 * Extensions} that wish to provide additional behavior to tests
 * <strong>immediately</strong> before an individual test is executed but after
 * any user-defined setup methods (e.g.,
 * {@link org.junit.jupiter.api.BeforeEach @BeforeEach} methods) have been
 * executed for that test.
 *
 * <p>Concrete implementations often implement {@link AfterTestExecutionCallback}
 * as well. If you wish to have your callbacks <em>wrapped</em> around user-defined
 * setup and teardown methods, implement {@link BeforeEachCallback} and
 * {@link AfterEachCallback} instead of {@link BeforeTestExecutionCallback} and
 * {@link AfterTestExecutionCallback}.
 *
 * <h2>Constructor Requirements</h2>
 *
 * <p>Consult the documentation in {@link Extension} for details on
 * constructor requirements.
 *
 * <h2>Wrapping Behavior</h2>
 *
 * <p>JUnit Jupiter guarantees <em>wrapping behavior</em> for multiple
 * registered extensions that implement lifecycle callbacks such as
 * {@link BeforeAllCallback}, {@link AfterAllCallback},
 * {@link BeforeClassTemplateInvocationCallback},
 * {@link AfterClassTemplateInvocationCallback}, {@link BeforeEachCallback},
 * {@link AfterEachCallback}, {@link BeforeTestExecutionCallback}, and
 * {@link AfterTestExecutionCallback}.
 *
 * <p>That means that, given two extensions {@code Extension1} and
 * {@code Extension2} with {@code Extension1} registered before
 * {@code Extension2}, any "before" callbacks implemented by {@code Extension1}
 * are guaranteed to execute before any "before" callbacks implemented by
 * {@code Extension2}. Similarly, given the two same two extensions registered
 * in the same order, any "after" callbacks implemented by {@code Extension1}
 * are guaranteed to execute after any "after" callbacks implemented by
 * {@code Extension2}. {@code Extension1} is therefore said to <em>wrap</em>
 * {@code Extension2}.
 *
 * @since 5.0
 * @see org.junit.jupiter.api.Test
 * @see AfterTestExecutionCallback
 * @see BeforeEachCallback
 * @see AfterEachCallback
 * @see BeforeAllCallback
 * @see AfterAllCallback
 * @see BeforeClassTemplateInvocationCallback
 * @see AfterClassTemplateInvocationCallback
 */
@FunctionalInterface
@API(status = STABLE, since = "5.0")
public interface BeforeTestExecutionCallback extends Extension {

	/**
	 * Callback that is invoked <em>immediately before</em> an individual test is
	 * executed but after any user-defined setup methods have been executed
	 * for that test.
	 *
	 * @param context the current extension context; never {@code null}
	 */
	void beforeTestExecution(ExtensionContext context) throws Exception;

}
