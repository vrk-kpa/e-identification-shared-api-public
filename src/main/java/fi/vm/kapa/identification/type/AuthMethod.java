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
package fi.vm.kapa.identification.type;

public enum AuthMethod {
    INIT ("0"),
    KATSOOTP ("urn:oid:1.2.246.517.3002.110.5"),
    KATSOPWD ("urn:oid:1.2.246.517.3002.110.6"),
    MPASS1 ("urn:oid:1.2.246.517.3002.110.11"),
    EIDAS1 ("urn:oid:1.2.246.517.3002.110.998"),
    EIDAS_LOA2 ("urn:oid:1.2.246.517.3002.110.997"),
    EIDAS_LOA3 ("urn:oid:1.2.246.517.3002.110.996"),
    TESTI ("urn:oid:1.2.246.517.3002.110.999"),
    TESTIDP("urn:oid:1.2.246.517.3002.110.995"),
    fLoA2 ("http://ftn.ficora.fi/2017/loa2"),
    fLoA3 ("http://ftn.ficora.fi/2017/loa3"),
    eLoA2 ("http://eidas.europa.eu/LoA/substantial"),
    eLoA3 ("http://eidas.europa.eu/LoA/high");

    private final String oidValue;

    AuthMethod(String oidValue) {
        this.oidValue = oidValue;
    }

    public String getOidValue() {
        return this.oidValue;
    }

    public static AuthMethod fromOid(String oid) throws IllegalOidException {
        for (AuthMethod authMethod : AuthMethod.values()) {
            if (authMethod.getOidValue().contentEquals(oid)) {
                return authMethod;
            }
        }
        throw new IllegalOidException("AuthMethod not found for oid: " + oid);
    }

    public static class IllegalOidException extends Exception {
        public IllegalOidException(String s) {
            super(s);
        }
    }
}
