package com.hg.basket.model;

import java.io.Serializable;
import java.util.Objects;
import lombok.Data;
import org.joda.time.DateTime;

@Data
public class Discount implements Serializable {

    private static final long serialVersionUID = -229548987674336427L;

    private String offer;
    private DateTime validFrom;
    private DateTime validTo;

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), offer, validFrom, validTo);
    }
}
