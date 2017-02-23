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

import org.apache.commons.lang.StringUtils;


public class TupasStampIdService {

    private static final int TUPAS_STAMP_LENGTH = 20;
    
    private static TupasStampIdService instance = null;
    
    private int tupasStampCounter;
    
    
    public static TupasStampIdService getInstance() {
        if (instance == null) {
            instance = new TupasStampIdService();
        }

        return instance;
    }

    
    public String getTupasStampCounter(int lengthOfTimeStamp) {
        int len = TUPAS_STAMP_LENGTH - lengthOfTimeStamp;
        tupasStampCounter++;
        
        if (tupasStampCounter == 9999 ) {
            tupasStampCounter = 1;
        }
        
        String strTupasStampCounter = Long.toString(tupasStampCounter);
        String tupasStampStr = StringUtils.leftPad(strTupasStampCounter, len, "0");
               
        return tupasStampStr;
    }
}
