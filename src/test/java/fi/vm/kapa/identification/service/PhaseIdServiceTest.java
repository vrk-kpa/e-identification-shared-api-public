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

import java.security.NoSuchAlgorithmException;
import java.time.Clock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class PhaseIdServiceTest {

    private final long startTimeMillisFixed = System.currentTimeMillis();

    @Mock
    private Clock testClock;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(testClock.millis()).thenReturn(startTimeMillisFixed);
    }

    @Test
    public void verifyReturnsTrueIfCalledAfterTimeInterval() throws Exception {
        int timeInterval = 10;
        PhaseIdService phaseIdService = getHmacPhaseIdServiceWithInteval(timeInterval);

        String randomToken = "randomToken";
        String stepOne = "STEP_ONE";
        String phaseId = phaseIdService.newPhaseId(randomToken, stepOne);
        // actual test
        advanceClockBy(timeInterval);
        Assert.assertTrue(phaseIdService.verifyPhaseId(phaseId, randomToken, stepOne));
    }

    @Test
    public void verifyReturnsFalseIfCalledAfterTwoTimeIntervals() throws Exception {
        int timeInterval = 10;
        PhaseIdService phaseIdService = getHmacPhaseIdServiceWithInteval(timeInterval);

        String randomToken = "randomToken";
        String stepOne = "STEP_ONE";
        String phaseId = phaseIdService.newPhaseId(randomToken, stepOne);
        // actual test
        advanceClockBy(timeInterval);
        advanceClockBy(timeInterval);
        Assert.assertFalse(phaseIdService.verifyPhaseId(phaseId, randomToken, stepOne));
    }

    @Test
    public void verifyReturnsTrueIfCalledTimeIntervalBeforeCreated() throws Exception {
        int timeInterval = 10;
        PhaseIdService phaseIdService = getHmacPhaseIdServiceWithInteval(timeInterval);

        String randomToken = "randomToken";
        String stepOne = "STEP_ONE";
        String phaseId = phaseIdService.newPhaseId(randomToken, stepOne);
        // actual test
        reverseClockBy(timeInterval);
        Assert.assertTrue(phaseIdService.verifyPhaseId(phaseId, randomToken, stepOne));
    }

    @Test
    public void verifyReturnsFalseIfCalledTwoTimeIntervalsBeforeCreated() throws Exception {
        int timeInterval = 10;
        PhaseIdService phaseIdService = getHmacPhaseIdServiceWithInteval(timeInterval);

        String randomToken = "randomToken";
        String stepOne = "STEP_ONE";
        String phaseId = phaseIdService.newPhaseId(randomToken, stepOne);
        // actual test
        reverseClockBy(timeInterval);
        reverseClockBy(timeInterval);
        Assert.assertFalse(phaseIdService.verifyPhaseId(phaseId, randomToken, stepOne));
    }


    @Test
    public void verifyReturnsTrueForValidPhaseId() throws Exception {
        String stepCounterOne = "ONE";
        String stepCounterTwo = "TWO";

        PhaseIdService phaseIdService = getHmacPhaseIdServiceWithInteval(10);
        Assert.assertNotNull(phaseIdService);

        String firstToken = "first";
        String phaseId = phaseIdService.newPhaseId(firstToken, stepCounterOne);
        Assert.assertNotNull(phaseId);

        Assert.assertEquals(true, phaseIdService.verifyPhaseId(phaseId, firstToken, stepCounterOne));
        String nextPhaseId = phaseIdService.newPhaseId(firstToken, stepCounterTwo);
        Assert.assertNotNull(nextPhaseId);

        Assert.assertEquals(true, phaseIdService.verifyPhaseId(nextPhaseId, firstToken, stepCounterTwo));
    }

    @Test(expected = NoSuchAlgorithmException.class)
    public void testCreateInvalidCalculator() throws Exception {
        String sharedSecret = "somerandomstring";
        String hmacAlgorithm = "AsdfQwerty";

        new PhaseIdService(sharedSecret, 10, hmacAlgorithm);
    }

    @Test
    public void verifyReturnsFalseForBogusPhaseId() throws Exception {
        String stepCounterOne = "ONE";
        String stepCounterTwo = "TWO";

        PhaseIdService phaseIdService = getHmacPhaseIdServiceWithInteval(10);
        Assert.assertNotNull(phaseIdService);

        String firstToken = "first";
        String phaseId = phaseIdService.newPhaseId(firstToken, stepCounterOne);
        Assert.assertNotNull(phaseId);

        String secondToken = "second";
        Assert.assertEquals(true, phaseIdService.verifyPhaseId(phaseId, firstToken, stepCounterOne));
        String nextPhaseId = phaseIdService.newPhaseId(secondToken, stepCounterTwo);
        Assert.assertNotNull(nextPhaseId);

        Assert.assertEquals(false, phaseIdService.verifyPhaseId(nextPhaseId, secondToken, stepCounterOne));
        Assert.assertEquals(false, phaseIdService.verifyPhaseId(phaseId, secondToken, stepCounterTwo));
    }

    @Test
    public void testValidateTidAndPid() throws Exception {
        String stepCounterOne = "ONE";

        PhaseIdService phaseIdService = getHmacPhaseIdServiceWithInteval(10);
        Assert.assertNotNull(phaseIdService);

        int i = 0;
        for (; i < 100; i++) {
            String tokenId = phaseIdService.nextTokenId();
            String phaseId = phaseIdService.newPhaseId(tokenId, stepCounterOne);
            Assert.assertNotNull(phaseId);
            Assert.assertEquals(true, phaseIdService.validateTidAndPid(tokenId, phaseId));
            Assert.assertEquals(true, phaseIdService.verifyPhaseId(phaseId, tokenId, stepCounterOne));
        }
        Assert.assertEquals(100, i);
    }

    @Test
    public void testValidateInvalidTidAndPid() throws Exception {
        String stepCounterOne = "ONE";

        PhaseIdService phaseIdService = getHmacPhaseIdServiceWithInteval(10);
        Assert.assertNotNull(phaseIdService);

        String invalidTokenId = "asdfqwerty";
        String phaseId = phaseIdService.newPhaseId(invalidTokenId, stepCounterOne);
        Assert.assertNotNull(phaseId);
        Assert.assertEquals(false, phaseIdService.validateTidAndPid(invalidTokenId, phaseId));

        invalidTokenId = "asdlfjh43=2va?sdfdsllsv3ls";
        Assert.assertEquals(false, phaseIdService.validateTidAndPid(invalidTokenId, phaseId));

        String validTokenId = "uuvljsorj9re42n9o2002a1k41";
        String invalidPhaseId = "qwerty";
        Assert.assertEquals(false, phaseIdService.validateTidAndPid(validTokenId, invalidPhaseId));

        invalidPhaseId = "fshf34löhsdflun?sdflsdhlfjhkhskjhvdkjhsk34kehf73kufkuhwk8fhkwhf8";
        Assert.assertEquals(false, phaseIdService.validateTidAndPid(validTokenId, invalidPhaseId));

        invalidPhaseId = "fshf34löhsdflunAsdflsdhlfjhkhskjhvdkjhsk34kehf73kufkuhwk8fhkwhf8";
        Assert.assertEquals(false, phaseIdService.validateTidAndPid(validTokenId, invalidPhaseId));
    }

    private PhaseIdService getHmacPhaseIdServiceWithInteval(int timeInterval) throws Exception {
        return new PhaseIdService(testClock, "somerandomstring", timeInterval, "HmacSHA256");
    }

    private void advanceClockBy(int timeInterval) {
        long newMillis = testClock.millis() + timeInterval * 1000;
        when(testClock.millis()).thenReturn(newMillis);
    }

    private void reverseClockBy(int timeInterval) {
        long newMillis = testClock.millis() - timeInterval * 1000;
        when(testClock.millis()).thenReturn(newMillis);
    }

}
