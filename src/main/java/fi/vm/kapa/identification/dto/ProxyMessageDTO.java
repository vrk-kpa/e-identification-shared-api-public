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
package fi.vm.kapa.identification.dto;

import fi.vm.kapa.identification.type.ErrorType;

/**
 * This class is used as the transfer object for delivering messages
 * to and from Proxy Server. This class should not contain any vital
 * session information apart from conversation key, which is required
 * by Shibboleth IdP but all other values are by themselves meaningless.
 */
public class ProxyMessageDTO {

    private String tokenId;

    private String phaseId;

    private String conversationKey;

    private String uid;

    private ErrorType errorType;

    private String loaProfile;

    private String authenticationMethods;

    private String usedAuthenticationMethod;

    // Setters and getters

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(String phaseId) {
        this.phaseId = phaseId;
    }

    public String getConversationKey() {
        return conversationKey;
    }

    public void setConversationKey(String conversationKey) {
        this.conversationKey = conversationKey;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }

    public String getLoaProfile() {
        return loaProfile;
    }

    public void setLoaProfile(String loaProfile) {
        this.loaProfile = loaProfile;
    }

    public String getAuthenticationMethods() {
        return authenticationMethods;
    }

    public void setAuthenticationMethods(String authenticationMethods) {
        this.authenticationMethods = authenticationMethods;
    }

    public String getUsedAuthenticationMethod() {
        return usedAuthenticationMethod;
    }

    public void setUsedAuthenticationMethod(String usedAuthenticationMethod) {
        this.usedAuthenticationMethod = usedAuthenticationMethod;
    }
}
