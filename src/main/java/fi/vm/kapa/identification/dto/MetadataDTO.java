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

import fi.vm.kapa.identification.type.ProviderType;
import fi.vm.kapa.identification.type.SessionProfile;

import java.util.List;

/**
 * This class is used to transfer and store metadata related to
 * actual Identity Providers and Service Providers.
 */
public class MetadataDTO {

    private String entityId;

    private String name;

    private String acsAddress;

    private String sloAddress;

    private String pubKey;

    private String userAttributes;

    private ProviderType providerType;

    private String dnsName;

    private String levelOfAssurance;

    private String attributeLevelOfAssurance;

    private SessionProfile sessionProfile;

    private String ssoUrl;

    private MultiLanguageDTO displayName;

    private MultiLanguageDTO organizationName;

    private MultiLanguageDTO description;

    private MultiLanguageDTO privacyStatement;

    private MetadataContactInfoDTO administrativeContact;

    private MetadataContactInfoDTO technicalContact;

    private List<AuthenticationProviderDTO> authenticationProviderDTOList;
    
    private boolean vtjVerificationRequired;

    public MetadataDTO() {
        vtjVerificationRequired = true;
    }

    // Getters and setters

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public ProviderType getProviderType() {
        return providerType;
    }

    public void setProviderType(ProviderType providerType) {
        this.providerType = providerType;
    }

    public String getDnsName() {
        return dnsName;
    }

    public void setDnsName(String dnsName) {
        this.dnsName = dnsName;
    }

    public String getLevelOfAssurance() {
        return levelOfAssurance;
    }

    public void setLevelOfAssurance(String levelOfAssurance) {
        this.levelOfAssurance = levelOfAssurance;
    }

    public SessionProfile getSessionProfile() {
        return sessionProfile;
    }

    public void setSessionProfile(SessionProfile sessionProfile) {
        this.sessionProfile = sessionProfile;
    }

    public String getSsoUrl() {
        return ssoUrl;
    }

    public void setSsoUrl(String ssoUrl) {
        this.ssoUrl = ssoUrl;
    }

    public MultiLanguageDTO getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(MultiLanguageDTO organizationName) {
        this.organizationName = organizationName;
    }

    public MetadataContactInfoDTO getAdministrativeContact() {
        return administrativeContact;
    }

    public void setAdministrativeContact(MetadataContactInfoDTO administrativeContact) {
        this.administrativeContact = administrativeContact;
    }

    public MetadataContactInfoDTO getTechnicalContact() {
        return technicalContact;
    }

    public void setTechnicalContact(MetadataContactInfoDTO technicalContact) {
        this.technicalContact = technicalContact;
    }

    public String getAcsAddress() {
        return acsAddress;
    }

    public void setAcsAddress(String acsAddress) {
        this.acsAddress = acsAddress;
    }

    public String getSloAddress() {
        return sloAddress;
    }

    public void setSloAddress(String sloAddress) {
        this.sloAddress = sloAddress;
    }

    public String getPubKey() {
        return pubKey;
    }

    public void setPubKey(String pubKey) {
        this.pubKey = pubKey;
    }

    public String getUserAttributes() {
        return userAttributes;
    }

    public void setUserAttributes(String userAttributes) {
        this.userAttributes = userAttributes;
    }

    public void setAuthenticationProviderDTOList(List<AuthenticationProviderDTO> dtoList) {
        authenticationProviderDTOList = dtoList;
    }

    public List<AuthenticationProviderDTO> getAuthenticationProviderDTOList() {
        return authenticationProviderDTOList;
    }

    public String getAttributeLevelOfAssurance() {
        return attributeLevelOfAssurance;
    }

    public void setAttributeLevelOfAssurance(String attributeLevelOfAssurance) {
        this.attributeLevelOfAssurance = attributeLevelOfAssurance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultiLanguageDTO getDisplayName() {
        return displayName;
    }

    public void setDisplayName(MultiLanguageDTO displayName) {
        this.displayName = displayName;
    }

    public MultiLanguageDTO getDescription() {
        return description;
    }

    public void setDescription(MultiLanguageDTO description) {
        this.description = description;
    }

    public MultiLanguageDTO getPrivacyStatement() {
        return privacyStatement;
    }

    public void setPrivacyStatement(MultiLanguageDTO privacyStatement) {
        this.privacyStatement = privacyStatement;
    }

    public boolean isVtjVerificationRequired() {
        return vtjVerificationRequired;
    }

    public void setVtjVerificationRequired(boolean vtjVerificationRequired) {
        this.vtjVerificationRequired = vtjVerificationRequired;
    }
}
