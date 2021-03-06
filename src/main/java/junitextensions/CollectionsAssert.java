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

import java.util.Collection;
import java.util.Collections;

import org.junit.Assert;

/**
 * Provides additional assert operations related to the {@link Collections} classes.
 * @author Peter Nerg
 * @since 1.1
 */
public interface CollectionsAssert extends NotNullAssert {

    /**
     * Assert that a collection is empty.
     * @param collection The collection to assert
     * @since 1.1
     */
    default void assertIsEmpty(Collection<?> collection) {
    	assertObjectNotNull(collection);
        Assert.assertTrue("Expected collection to be empty", collection.isEmpty());
    }

    /**
     * Assert that a collection is <u>not</u> empty.
     * @param collection The collection to assert
     * @since 1.1
     */
    default void assertIsNotEmpty(Collection<?> collection) {
    	assertObjectNotNull(collection);
        Assert.assertFalse("Expected collection to contain something", collection.isEmpty());
    }
}
