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

import org.junit.Assert;

import javascalautils.None;
import javascalautils.Option;
import javascalautils.Some;

/**
 * Provides additional assert operations related to the {@link Option} class.
 * @author Peter Nerg
 * @since 1.0
 */
public interface OptionAssert {

    /**
     * Assert that the provided {@link Option} is a {@link Some}.
     * @param option The Option to assert
     * @since 1.0
     */
    default void assertIsSome(Option<?> option) {
    	Assert.assertTrue("Expected the Option ["+option+"] to be Some", option.isDefined());
    }

    /**
     * Assert that the provided {@link Option} is a {@link None}.
     * @param option The Option to assert
     * @since 1.0
     */
    default void assertIsNone(Option<?> option) {
    	Assert.assertTrue("Expected the Option ["+option+"] to be None", option.isEmpty());
    }


    /**
     * Assert that the provided {@link Option} is a {@link Some} and it holds the expected value.
     * @param expected The expected value of the Some
     * @param option The Option to assert
     * @since 1.0
     */
    default void assertSomeEquals(Object expected, Option<?> option) {
    	assertIsSome(option);
    	Assert.assertEquals("Unexpected value on Some", expected, option.get());
    }	
}
