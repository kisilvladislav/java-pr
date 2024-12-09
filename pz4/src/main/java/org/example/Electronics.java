package org.example;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Builder;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class Electronics extends Product {
    private String name;
    private String brand;
    private String model;
}