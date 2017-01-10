package com.cefothe.judge.parse;

import org.modelmapper.PropertyMap;

/**
 * Created by cefothe on 10.01.17.
 */
public interface ModelParser {
    <S,D> D convert(S source, Class<D> destinationClass);
    <S,D> D convert(S source, Class<D> destinationClass, PropertyMap<S, D> propertyMap);
}
