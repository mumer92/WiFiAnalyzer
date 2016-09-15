/*
 * Copyright (C) 2015 - 2016 VREM Software Development <VREMSoftwareDevelopment@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.vrem.wifianalyzer.vendor.model;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class VendorNameUtilsTest {

    @Test
    public void testCleanVendorNameWithNull() throws Exception {
        // execute
        String actual = VendorNameUtils.cleanVendorName(null);
        // validate
        assertEquals(StringUtils.EMPTY, actual);
    }

    @Test
    public void testCleanVendorNameWithBlank() throws Exception {
        // execute
        String actual = VendorNameUtils.cleanVendorName("   ");
        // validate
        assertEquals(StringUtils.EMPTY, actual);
    }

    @Test
    public void testCleanVendorNameWithSpecialCharacters() throws Exception {
        // setup
        String input = "X.Y.Z _ ABC + 123 : ~ ^ # $ % ! @ `& * ; ? | 567  -  Z,Y,X";
        String expected = "X Y Z ABC 123 567 Z Y X";
        // execute
        String actual = VendorNameUtils.cleanVendorName(input);
        // validate
        assertEquals(expected, actual);
    }

    @Test
    public void testCleanVendorNameWithMaximumLength() throws Exception {
        // setup
        String input = "123456789012345678901234567890123456789012345678901234567890";
        int expected = 50;
        // execute
        String actual = VendorNameUtils.cleanVendorName(input);
        // validate
        assertEquals(expected, actual.length());
    }

}