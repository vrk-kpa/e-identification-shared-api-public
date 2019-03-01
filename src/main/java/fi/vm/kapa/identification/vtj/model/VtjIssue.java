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
package fi.vm.kapa.identification.vtj.model;

import java.util.StringJoiner;
import java.util.regex.Pattern;

public class VtjIssue {

    public static final String REQUEST_IDENTIFIER_HEADER = "X-XRoad-request-id";

    protected static final String DELIMITER = "|";

    private String sessionId;
    private String conversationKey;
    private String count;
    private String vtjClientId;

    public VtjIssue() {
        this(null);
    }

    public VtjIssue(String issue) {
        String[] fields = issue != null ? issue.split(Pattern.quote(DELIMITER)) : new String[0];
        sessionId = getOrDefault(fields, 0);
        conversationKey = getOrDefault(fields, 1);
        count = getOrDefault(fields, 2);
        vtjClientId = getOrDefault(fields, 3);
    }

    public VtjIssue(String sessionId, String conversationKey, String count, String vtjClientId) {
        this.sessionId = sessionId != null ? sessionId : "";
        this.conversationKey = conversationKey != null ? conversationKey : "";
        this.count = count != null ? count : "";
        this.vtjClientId = vtjClientId != null ? vtjClientId : "";
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getConversationKey() {
        return conversationKey;
    }

    public void setConversationKey(String conversationKey) {
        this.conversationKey = conversationKey;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getVtjClientId() {
        return vtjClientId;
    }

    public void setVtjClientId(String vtjClientId) {
        this.vtjClientId = vtjClientId;
    }

    private String getOrDefault(String[] arr, int index) {
        if ( arr != null && arr.length > index ) {
            return arr[index];
        }
        return "";
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner(DELIMITER);
        joiner.add(sessionId).add(conversationKey).add(count).add(vtjClientId);
        return joiner.toString();
    }
}

