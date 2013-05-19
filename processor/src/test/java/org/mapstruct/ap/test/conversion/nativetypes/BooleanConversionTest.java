/**
 *  Copyright 2012-2013 Gunnar Morling (http://www.gunnarmorling.de/)
 *  and/or other contributors as indicated by the @authors tag. See the
 *  copyright.txt file in the distribution for a full listing of all
 *  contributors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.mapstruct.ap.test.conversion.nativetypes;

import org.mapstruct.ap.testutil.MapperTestBase;
import org.mapstruct.ap.testutil.WithClasses;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

@WithClasses({
    BooleanSource.class,
    BooleanTarget.class,
    BooleanMapper.class
})
public class BooleanConversionTest extends MapperTestBase {

    @Test
    public void shouldApplyBooleanConversion() {
        BooleanSource source = new BooleanSource();
        source.setBool( true );

        BooleanTarget target = BooleanMapper.INSTANCE.sourceToTarget( source );

        assertThat( target ).isNotNull();
        assertThat( target.getBool() ).isEqualTo( Boolean.TRUE );
    }

    @Test
    public void shouldApplyReverseBooleanConversion() {
        BooleanTarget target = new BooleanTarget();
        target.setBool( Boolean.TRUE );

        BooleanSource source = BooleanMapper.INSTANCE.targetToSource( target );

        assertThat( source ).isNotNull();
        assertThat( source.getBool() ).isEqualTo( true );
    }
}