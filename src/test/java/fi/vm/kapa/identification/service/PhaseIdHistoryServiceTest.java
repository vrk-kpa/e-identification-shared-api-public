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

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

public class PhaseIdHistoryServiceTest {

    private PhaseIdHistoryService historyService;
    private PhaseIdService phaseIdService;

    @Before
    public void setup() throws Exception {
        historyService = PhaseIdHistoryService.getInstance();
        phaseIdService = new PhaseIdService("secret", 10, "HmacSHA256");
    }

    @Test
    public void testAddIdsToHistory() throws Exception {
        String tokenId = phaseIdService.nextTokenId();
        String phaseId = phaseIdService.newPhaseId(tokenId, "one");

        assertEquals(false, historyService.areIdsConsumed(tokenId, phaseId));
        assertEquals(true, historyService.areIdsConsumed(tokenId, phaseId));
    }

    @Test
    public void addingHistoryMaxSizeTokensDoesNotRunCleanup() throws Exception {
        PhaseIdHistoryService historyServiceSpy = spy(PhaseIdHistoryService.class);
        HistoryServiceCaller historyServiceCaller = new HistoryServiceCaller(historyServiceSpy);
        invokeCallerTimes(historyServiceCaller, PhaseIdHistoryService.HISTORY_MAX_SIZE);
        verify(historyServiceSpy, times(PhaseIdHistoryService.HISTORY_MAX_SIZE)).areIdsConsumed(anyString(), anyString());
        verify(historyServiceSpy, never()).cleanup();
        Mockito.reset(historyServiceSpy);
    }

    @Test
    public void addingHistoryMaxSizePlusOneTokensRunsCleanupOnce() throws Exception {
        PhaseIdHistoryService historyServiceSpy = spy(PhaseIdHistoryService.class);
        HistoryServiceCaller historyServiceCaller = new HistoryServiceCaller(historyServiceSpy);
        invokeCallerTimes(historyServiceCaller, PhaseIdHistoryService.HISTORY_MAX_SIZE + 1);
        verify(historyServiceSpy, times(PhaseIdHistoryService.HISTORY_MAX_SIZE + 1)).areIdsConsumed(anyString(), anyString());
        verify(historyServiceSpy, times(1)).cleanup();
        verifyNoMoreInteractions(historyServiceSpy);
    }

    @Test
    public void addingTokensKeepsUsedTokenIdsSizeLimited() throws Exception {
        PhaseIdHistoryService historyServiceSpy = spy(PhaseIdHistoryService.class);
        HistoryServiceCaller historyServiceCaller = new HistoryServiceCaller(historyServiceSpy);
        invokeCallerTimes(historyServiceCaller, PhaseIdHistoryService.HISTORY_MAX_SIZE);
        verify(historyServiceSpy, never()).cleanup();
        // first cleanup
        invokeCallerTimes(historyServiceCaller, 1);
        int usedTokensSize = historyServiceSpy.getUsedTokensSize();

        // next cleanups come with each so many calls
        int cleanupInterval = PhaseIdHistoryService.HISTORY_MAX_SIZE - PhaseIdHistoryService.HISTORY_MIN_SIZE;
        invokeCallerTimes(historyServiceCaller, cleanupInterval);
        verify(historyServiceSpy, times(2)).cleanup();
        assertEquals(usedTokensSize, historyServiceSpy.getUsedTokensSize());

        invokeCallerTimes(historyServiceCaller, cleanupInterval);
        verify(historyServiceSpy, times(3)).cleanup();
        assertEquals(usedTokensSize, historyServiceSpy.getUsedTokensSize());
    }

    void invokeCallerTimes(HistoryServiceCaller historyServiceCaller, int times) {
        for (int i = 0; i < times; ) {
            if (historyServiceCaller.areIdsConsumed() == false) {
                i++;
            }
        }
    }


    private class HistoryServiceCaller {
        private PhaseIdHistoryService historyServiceSpy;

        public HistoryServiceCaller(PhaseIdHistoryService historyServiceSpy) {
            this.historyServiceSpy = historyServiceSpy;
        }

        public boolean areIdsConsumed() {
            String tokenId = phaseIdService.nextTokenId();
            String phaseId = null;
            try {
                phaseId = phaseIdService.newPhaseId(tokenId, "one");
            } catch (Exception e) {
                fail();
            }
            return historyServiceSpy.areIdsConsumed(tokenId, phaseId);
        }
    }
}
