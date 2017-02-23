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

import org.junit.Test;

import static org.junit.Assert.*;

public class TupasStampIdServiceTest {

    @Test
    public void getInstanceReturnsSameInstance() throws Exception {
        TupasStampIdService stampIdService = TupasStampIdService.getInstance();
        TupasStampIdService stampIdService2 = TupasStampIdService.getInstance();
        assertSame(stampIdService, stampIdService2);
    }

    @Test
    public void getTupasStampCounterReturnsOneOnFirstCall() throws Exception {
        TupasStampIdService stampIdService = new TupasStampIdService();
        String tupasStampCounter = stampIdService.getTupasStampCounter(20);
        assertEquals(1, tupasStampCounter.length());
        assertEquals(1, Long.valueOf(tupasStampCounter).longValue());
    }

    @Test
    public void getTupasStampCounterReturnsTwoOnSecondCall() throws Exception {
        TupasStampIdService stampIdService = new TupasStampIdService();
        stampIdService.getTupasStampCounter(20);
        // second call
        String tupasStampCounter = stampIdService.getTupasStampCounter(20);
        assertEquals(1, tupasStampCounter.length());
        assertEquals(2, Long.valueOf(tupasStampCounter).longValue());
    }

    @Test
    public void getTupasStampCounterReturnsOnePaddedToTwentyChars() throws Exception {
        TupasStampIdService stampIdService = new TupasStampIdService();
        String tupasStampCounter = stampIdService.getTupasStampCounter(0);
        assertEquals(20, tupasStampCounter.length());
        assertEquals('1', tupasStampCounter.charAt(19));
    }

    @Test
    public void getTupasStampCounterReturnsUnpaddedWhenCalledWith20() throws Exception {
        TupasStampIdService stampIdService = new TupasStampIdService();
        String tupasStampCounter = stampIdService.getTupasStampCounter(20);
        assertEquals(1, tupasStampCounter.length());
        assertEquals('1', tupasStampCounter.charAt(0));
    }

    @Test
    public void getTupasStampCounterRollsAfter9998() throws Exception {
        TupasStampIdService stampIdService = new TupasStampIdService();
        String tupasStampCounter = null;
        for (int i = 0; i < 9998; i++) {
            tupasStampCounter = stampIdService.getTupasStampCounter(20);
        }
        assertEquals(9998, Long.valueOf(tupasStampCounter).longValue());
        tupasStampCounter = stampIdService.getTupasStampCounter(20);
        assertEquals(1, Long.valueOf(tupasStampCounter).longValue());
    }
}