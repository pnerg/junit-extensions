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

import javascalautils.Failure;
import javascalautils.Success;
import javascalautils.Try;

/**
 * Provides additional assert operations related to the {@link Try} class.
 * @author Peter Nerg
 * @since 1.0
 */
public interface TryAssert extends NotNullAssert {

    /**
     * Asserts that the provided {@link Try} is a {@link Failure}.
     * @param t The Try instance to Assert
     * @since 1.0
     */
    default void assertFailure(Try<?> t) {
    	assertObjectNotNull(t);
    	Assert.assertTrue("Expected the Try ["+t+"] to be a Failure", t.isFailure());
    }

    /**
     * Asserts that the provided {@link Try} is a {@link Success}.
     * @param t The Try instance to Assert
     * @since 1.0
     */
    default void assertSuccess(Try<?> t) {
    	assertObjectNotNull(t);
    	Assert.assertTrue("Expected the Try ["+t+"] to be a Success", t.isSuccess());
    }
    
    /**
     * Assert that the provided {@link Try} is a {@link Success} and it holds the expected value.
     * @param <T> The type of the Try
     * @param expected The expected value of the Success
     * @param t The Try instance to Assert
     * @since 1.0
     */
    default <T> void assertSuccess(T expected, Try<T> t) {
    	assertSuccess(t);
    	//orNull will never happen as we've already asserted it to be a Success
    	Assert.assertEquals("Unexpected value ["+t+"] on Success", expected, t.orNull());
    }	

	
}
