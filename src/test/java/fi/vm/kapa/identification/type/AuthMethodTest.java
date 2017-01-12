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

import org.junit.Test;

import static org.junit.Assert.*;

public class AuthMethodTest {
    @Test
    public void fromOidReturnsMobiiliForMobiiliOid() throws Exception {
        assertEquals(AuthMethod.MOBIILI, AuthMethod.fromOid(AuthMethod.MOBIILI.getOidValue()));
    }

    @Test
    public void fromOidReturnsHstForHstOid() throws Exception {
        assertEquals(AuthMethod.HST, AuthMethod.fromOid(AuthMethod.HST.getOidValue()));
    }

    @Test
    public void fromOidReturnsKatsoOtpForKatsoOtpOid() throws Exception {
        assertEquals(AuthMethod.KATSOOTP, AuthMethod.fromOid(AuthMethod.KATSOOTP.getOidValue()));
    }

    @Test
    public void fromOidReturnsKatsoPwdForKatsoPwdOid() throws Exception {
        assertEquals(AuthMethod.KATSOPWD, AuthMethod.fromOid(AuthMethod.KATSOPWD.getOidValue()));
    }

    @Test
    public void fromOidReturnsTupasForTupasOid() throws Exception {
        assertEquals(AuthMethod.TUPAS, AuthMethod.fromOid(AuthMethod.TUPAS.getOidValue()));
    }

    @Test(expected = AuthMethod.IllegalOidException.class)
    public void fromOidThrowsForUnknownOid() throws Exception {
        AuthMethod.fromOid("urn:oid:1.2.3.4");
    }
}
