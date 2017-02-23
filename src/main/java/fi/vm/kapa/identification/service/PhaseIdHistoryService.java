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

import java.util.List;
import java.util.ArrayList;

/**
 * This class implements a generic singleton class that can be used to store
 * recently used token and phase IDs for security purposes. The main reason
 * for this is to prevent replay attacks by storing used token and phase IDs
 * for a small period of time which can be configured.
 */
public class PhaseIdHistoryService {

    public static final int HISTORY_MIN_SIZE = 20000;
    public static final int HISTORY_MAX_SIZE = 20100;
    private static PhaseIdHistoryService instance = null;

    private List<String> usedTokenIds = new ArrayList<>(HISTORY_MAX_SIZE);
    private List<String> usedPhaseIds = new ArrayList<>(HISTORY_MAX_SIZE);

    PhaseIdHistoryService() {
    }

    public static synchronized PhaseIdHistoryService getInstance() {
        if (instance == null) {
            instance = new PhaseIdHistoryService();
        }

        return instance;
    }

    public synchronized boolean areIdsConsumed(String tokenId, String phaseId) {
        if (usedTokenIds.contains(tokenId) || usedPhaseIds.contains(phaseId)) {
            return true;
        }
        usedTokenIds.add(tokenId);
        usedPhaseIds.add(phaseId);
        if (usedTokenIds.size() > (HISTORY_MAX_SIZE)) {
            cleanup();
        }
        return false;
    }

    // Only for class-internal and test use! To be refactored.
    void cleanup() {
        for (int i = 0; i < HISTORY_MAX_SIZE - HISTORY_MIN_SIZE; i++) {
            usedTokenIds.remove(0);
            usedPhaseIds.remove(0);
        }
    }

    int getUsedTokensSize() {
        return usedTokenIds.size();
    }

}
