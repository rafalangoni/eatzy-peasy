package com.langoni.eatzy_peasy.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@JacksonXmlRootElement(localName = "Kitchens")
public class KitchenXmlWrapper {

    @NonNull
    @JacksonXmlProperty(localName = "kitchen")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Kitchen> kitchen;
}
