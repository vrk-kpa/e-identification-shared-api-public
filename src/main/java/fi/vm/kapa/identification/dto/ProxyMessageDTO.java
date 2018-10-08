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

import fi.vm.kapa.identification.type.AuthMethod;
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

    private String levelOfAssurance;

    private String requestedAuthenticationMethods;

    private AuthMethod[] sessionAuthenticationMethods;

    private String eidasContactAddress;

    private String entityId;

    private String displayNameFI;

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

    public String getLevelOfAssurance() {
        return levelOfAssurance;
    }

    public void setLevelOfAssurance(String levelOfAssurance) {
        this.levelOfAssurance = levelOfAssurance;
    }

    public String getRequestedAuthenticationMethods() {
        return requestedAuthenticationMethods;
    }

    public void setRequestedAuthenticationMethods(String requestedAuthenticationMethods) {
        this.requestedAuthenticationMethods = requestedAuthenticationMethods;
    }

    public AuthMethod[] getSessionAuthenticationMethods() {
        return sessionAuthenticationMethods;
    }

    public void setSessionAuthenticationMethods(AuthMethod[] sessionAuthenticationMethods) {
        this.sessionAuthenticationMethods = sessionAuthenticationMethods;
    }

    public String getEidasContactAddress() {
        return eidasContactAddress;
    }

    public void setEidasContactAddress(String eidasContactAddress) {
        this.eidasContactAddress = eidasContactAddress;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getDisplayNameFI() {
        return displayNameFI;
    }

    public void setDisplayNameFI(String displayNameFI) {
        this.displayNameFI = displayNameFI;
    }
}
