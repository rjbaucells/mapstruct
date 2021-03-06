/**
 *  Copyright 2012-2015 Gunnar Morling (http://www.gunnarmorling.de/)
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
package org.mapstruct.ap.test.abstractclass.generics;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author Andreas Gudian
 *
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class GenericsHierarchyMapper {
    public static final GenericsHierarchyMapper INSTANCE = Mappers.getMapper( GenericsHierarchyMapper.class );

    @Mapping(target = "itemC", source = "item")
    public abstract Target toTarget(AbstractClassExposingItemC source);

    @Mapping(target = "itemB", source = "item")
    public abstract Target toTarget(AbstractClassExposingItemB source);

    @Mapping(target = "item", source = "itemC")
    public abstract void intoSourceWithItemC(Target target, @MappingTarget AbstractClassExposingItemC bean);

    @Mapping(target = "item", source = "itemB")
    public abstract void intoSourceWithItemB(Target target, @MappingTarget AbstractClassExposingItemB bean);

    protected ItemC modifyItemC(ItemC item) {
        item.setTypeParameterIsResolvedToItemC( true );
        return item;
    }

    protected ItemB modifyItemB(ItemB item) {
        item.setTypeParameterIsResolvedToItemB( true );
        return item;
    }
}
