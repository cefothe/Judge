package com.cefothe.judge.parse;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

/**
 * Created by cefothe on 10.01.17.
 */
@Component
public class ModelParserObjects implements ModelParser {
    private ModelMapper modelMapper;

    public ModelParserObjects() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public <S, D> D convert(S source, Class<D> destinationClass) {
        D convertedObject = null;
        convertedObject = this.modelMapper.map(source, destinationClass);
        return convertedObject;
    }

    @Override
    public <S, D> D convert(S source, Class<D> destinationClass, PropertyMap<S, D> propertyMap) {
        D convertedObject = null;
        this.modelMapper.addMappings(propertyMap);
        convertedObject = this.modelMapper.map(source, destinationClass);
        return convertedObject;
    }
}
