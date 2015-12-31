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

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * Test the class {@link CollectionsAssert}.
 * @author Peter Nerg
 */
public class TestCollectionsAssert extends BaseAssert implements CollectionsAssert {

	@Test
	public void assertIsEmpty_withEmpty() {
		assertIsEmpty(Collections.emptyList());
	}
	
	@Test(expected = AssertionError.class)
	public void assertIsEmpty_withNonEmpty() {
		Set<Object> set = new HashSet<>();
		set.add(new Object());
		assertIsEmpty(set);
	}

	@Test(expected = AssertionError.class)
	public void assertIsNotEmpty_withEmpty() {
		assertIsNotEmpty(Collections.emptyList());
	}
	
	@Test
	public void assertIsNotEmpty_withNonEmpty() {
		Set<Object> set = new HashSet<>();
		set.add(new Object());
		assertIsNotEmpty(set);
	}
}
