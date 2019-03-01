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

import org.junit.Test;

import static org.junit.Assert.*;

public class VtjIssueTest {

    private String sessionId = "sessionId123";
    private String conversationKey = "ckey123";
    private String count = "123";
    private String vtjClientId = "vtjClientId123";
    private String issueString = String.join(VtjIssue.DELIMITER, sessionId, conversationKey, count,vtjClientId);

    @Test
    public void testVtjIssueNoParameters() throws Exception {
        VtjIssue vtjIssue = new VtjIssue();
        assertEquals(VtjIssue.DELIMITER + VtjIssue.DELIMITER + VtjIssue.DELIMITER, vtjIssue.toString());
    }

    @Test
    public void testVtjIssueSetParameters() throws Exception {
        VtjIssue vtjIssue = new VtjIssue(sessionId, conversationKey, count, vtjClientId);;
        assertEquals(issueString, vtjIssue.toString());
    }

    @Test
    public void testVtjIssueWithIssueString() {
        VtjIssue vtjIssue = new VtjIssue(issueString);
        assertEquals(sessionId, vtjIssue.getSessionId());
        assertEquals(conversationKey, vtjIssue.getConversationKey());
        assertEquals(count, vtjIssue.getCount());
        assertEquals(vtjClientId, vtjIssue.getVtjClientId());
    }
}
