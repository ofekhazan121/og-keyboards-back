package com.example.OGKeys.model;

import lombok.Data;

@Data
public class StatusUpdate {

    String workerId;
    Status status;
    long orderNumber;
}
