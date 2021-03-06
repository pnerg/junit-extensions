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
import static javascalautils.OptionCompanion.Some;
import static javascalautils.OptionCompanion.None;

/**
 * Test the class {@link OptionAssert}
 * @author Peter Nerg
 */
public class TestOptionAssert implements OptionAssert {

	@Test
	public void assertIsSome_withSome() {
		assertSome(Some("Some is never None"));
	}
	
	@Test(expected=AssertionError.class)
	public void assertIsSome_withNone() {
		assertSome(None());
	}

	@Test(expected=AssertionError.class)
	public void assertIsNone_withSome() {
		assertNone(Some("Some is never None"));
	}
	
	@Test
	public void assertIsNone_withNone() {
		assertNone(None());
	}
	
	@Test
	public void assertSomeEquals_withMatchingSome() {
		String expected = "Some is never None";
		assertSome(expected, Some(expected));
	}

	@Test
	public void assertSomeEquals_withMatchingSome_Object() {
		Object expected = new Object();
		assertSome(expected, Some(expected));
	}

	@Test(expected=AssertionError.class)
	public void assertSomeEquals_withNonMatchingSome() {
		String expected = "Some is never None";
		assertSome(expected, Some(expected.toUpperCase()));
	}

	@Test(expected=AssertionError.class)
	public void assertSomeEquals_withNone() {
		assertSome("Doesn't matter", None());
	}
}
