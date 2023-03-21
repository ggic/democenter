package com.snoweagle.dc.domain.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServerConfig {
    private int port ;
}
