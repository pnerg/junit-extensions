/**
 *  Copyright 2015 Peter Nerg
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package junitextensions;

import org.junit.Test;

/**
 * Test the class {@link ReflectionAssert}
 * @author Peter Nerg
 */
public class TestReflectionAssert extends BaseAssert implements ReflectionAssert {

	@Test
	public void assertPrivateConstructor_successful() {
		assertPrivateConstructor(DummyClassWithPrivateConstructor.class);
	}
	
	@Test(expected = AssertionError.class)
	public void assertPrivateConstructor_failure() {
		assertPrivateConstructor(DummyClassWithPrivateConstructorFailingCreation.class);
	}

	@Test(expected = AssertionError.class)
	public void assertPrivateConstructor_withPublicConstructor() {
		assertPrivateConstructor(TestReflectionAssert.class);
	}

	@Test(expected = AssertionError.class)
	public void assertPrivateConstructor_withoutDefaultConstructor() {
		assertPrivateConstructor(DummyClassWithoutDefaultConstructor.class);
	}
}
