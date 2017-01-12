/**
 * The MIT License
 * Copyright (c) 2015 Population Register Centre
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package fi.vm.kapa.identification.service;

/**
 * This class is intended as a general purpose tool for checking
 * any URL related data. This class is mainly used to validate
 * entity IDs and request URLs that must match certain criteria
 * within the identification process.
 */
public class UrlParamService {

    private static final String ENTITY_ID_PATTERN = "^[a-zA-Z0-9\\-\\.:/_]{10,255}$";

    /**
     * Verifies if given entity ID matches the allowed entity ID
     * format that is used in metadata
     *
     * @param entityId the URL to be verified
     * @return Boolean value, true if given URL matches the allowed format
     */
    public static boolean isValidEntityId(String entityId) {
        return entityId.matches(ENTITY_ID_PATTERN);
    }

}
