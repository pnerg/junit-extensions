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
 * @author Peter Nerg
 *
 */
public class TestOptionAssert implements OptionAssert {

	@Test
	public void assertIsSome_withSome() {
		assertIsSome(Some("Some is never None"));
	}
	
	@Test(expected=AssertionError.class)
	public void assertIsSome_withNone() {
		assertIsSome(None());
	}
}
