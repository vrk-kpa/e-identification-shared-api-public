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


public class Person {

    private String hetu;
    private boolean hetuValid;
    private String satu;
    private boolean satuValid;
    private String lastName;
    private String firstNames;
    private String nickName;
    private String emailAddress;
    
    private String municipalityCode;
    private String municipalityS;
    private String municipalityR;
    
    private String domesticAddressS;
    private String domesticAddressR;
    private String postalCode;
    private String cityS;
    private String cityR;
    
    private String foreignAddress;
    private String foreignLocalityAndStateS;
    private String foreignLocalityAndStateR;
    private String foreignLocalityAndStateClearText;
    private String stateCode;
    
    private String temporaryDomesticAddressS;
    private String temporaryDomesticAddressR;
    private String temporaryPostalCode;
    private String temporaryCityS;
    private String temporaryCityR;    
          
    private String finnishCitizenship;
    
    private boolean deceased;
    private boolean protectionOrder;
    
      
    public String getHetu() {
        return hetu;
    }

    public void setHetu(String hetu) {
        this.hetu = hetu;
    }

    public boolean isHetuValid() {
        return hetuValid;
    }

    public void setHetuValid(boolean hetuValid) {
        this.hetuValid = hetuValid;
    }

    public String getSatu() {
        return satu;
    }

    public void setSatu(String satu) {
        this.satu = satu;
    }

    public boolean isSatuValid() {
        return satuValid;
    }

    public void setSatuValid(boolean satuValid) {
        this.satuValid = satuValid;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstNames() {
        return firstNames;
    }

    public void setFirstNames(String firstNames) {
        this.firstNames = firstNames;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public boolean isDeceased() {
        return deceased;
    }

    public void setDeceased(boolean deceased) {
        this.deceased = deceased;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMunicipalityCode() {
        return municipalityCode;
    }

    public void setMunicipalityCode(String municipalityCode) {
        this.municipalityCode = municipalityCode;
    }

    public String getMunicipalityS() {
        return municipalityS;
    }

    public void setMunicipalityS(String municipalityS) {
        this.municipalityS = municipalityS;
    }

    public String getMunicipalityR() {
        return municipalityR;
    }

    public void setMunicipalityR(String municipalityR) {
        this.municipalityR = municipalityR;
    }

    public String getDomesticAddressS() {
        return domesticAddressS;
    }

    public void setDomesticAddressS(String domesticAddressS) {
        this.domesticAddressS = domesticAddressS;
    }

    public String getDomesticAddressR() {
        return domesticAddressR;
    }

   public void setDomesticAddressR(String domesticAddressR) {
        this.domesticAddressR = domesticAddressR;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCityS() {
        return cityS;
    }

    public void setCityS(String cityS) {
        this.cityS = cityS;
    }

    public String getCityR() {
        return cityR;
    }

    public void setCityR(String cityR) {
        this.cityR = cityR;
    }

    public String getForeignAddress() {
        return foreignAddress;
    }

    public void setForeignAddress(String foreignAddress) {
        this.foreignAddress = foreignAddress;
    }

    public String getForeignLocalityAndStateS() {
        return foreignLocalityAndStateS;
    }

    public void setForeignLocalityAndStateS(String foreignLocalityAndStateS) {
        this.foreignLocalityAndStateS = foreignLocalityAndStateS;
    }

    public String getForeignLocalityAndStateR() {
        return foreignLocalityAndStateR;
    }

    public void setForeignLocalityAndStateR(String foreignLocalityAndStateR) {
        this.foreignLocalityAndStateR = foreignLocalityAndStateR;
    }

    public String getForeignLocalityAndStateClearText() {
        return foreignLocalityAndStateClearText;
    }

    public void setForeignLocalityAndStateClearText(
            String foreignLocalityAndStateClearText) {
        this.foreignLocalityAndStateClearText = foreignLocalityAndStateClearText;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getTemporaryDomesticAddressS() {
        return temporaryDomesticAddressS;
    }

    public void setTemporaryDomesticAddressS(String temporaryDomesticAddressS) {
        this.temporaryDomesticAddressS = temporaryDomesticAddressS;
    }

    public String getTemporaryDomesticAddressR() {
        return temporaryDomesticAddressR;
    }

    public void setTemporaryDomesticAddressR(String temporaryDomesticAddressR) {
        this.temporaryDomesticAddressR = temporaryDomesticAddressR;
    }

    public String getTemporaryPostalCode() {
        return temporaryPostalCode;
    }

    public void setTemporaryPostalCode(String temporaryPostalCode) {
        this.temporaryPostalCode = temporaryPostalCode;
    }

    public String getTemporaryCityS() {
        return temporaryCityS;
    }

    public void setTemporaryCityS(String temporaryCityS) {
        this.temporaryCityS = temporaryCityS;
    }

    public String getTemporaryCityR() {
        return temporaryCityR;
    }

    public void setTemporaryCityR(String temporaryCityR) {
        this.temporaryCityR = temporaryCityR;
    }

    public boolean isProtectionOrder() {
        return protectionOrder;
    }

    public void setProtectionOrder(boolean protectionOrder) {
        this.protectionOrder = protectionOrder;
    }


    public String getFinnishCitizenship() {
        return finnishCitizenship;
    }

    public void setFinnishCitizenship(String finnishCitizenship) {
        this.finnishCitizenship = finnishCitizenship;
    }

    @Override
    public String toString() {
        return "Person [ssn=" + hetu + ", ssnValid=" + hetuValid + "]";
    }
}
