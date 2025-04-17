package com.scaler.userservicejan31capstone.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter

public class Token
{
    private String value;
    private Date expiryAt;
}
