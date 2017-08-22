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

public class AuthenticationProviderDTO {

    private String name; //db: name
    private String domainName; //db: dnsname
    private String authenticationMethod; //db: attr_loa, authentication method authenticationMethod: HST, TUPAS etc.
    private String authProviderAuthContextUrl; //db: acsAddress, auth context class/decl value (oid or url) used in end-IdP reply
    private String dbEntityIdAuthContextUrl; //db: entityid

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getAuthenticationMethod() {
        return authenticationMethod;
    }

    public void setAuthenticationMethod(String authenticationMethod) {
        this.authenticationMethod = authenticationMethod;
    }

    public String getAuthProviderAuthContextUrl() {
        return authProviderAuthContextUrl;
    }

    public void setAuthProviderAuthContextUrl(String authProviderAuthContextUrl) {
        this.authProviderAuthContextUrl = authProviderAuthContextUrl;
    }

    public String getDbEntityIdAuthContextUrl() {
        return dbEntityIdAuthContextUrl;
    }

    public void setDbEntityIdAuthContextUrl(String dbEntityIdAuthContextUrl) {
        this.dbEntityIdAuthContextUrl = dbEntityIdAuthContextUrl;
    }

    //disco-id is user interface identifier that is formed from name
    public String getDiscoId() {
        return "disco-" + getName().toLowerCase();
    }
}
