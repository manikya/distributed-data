package lk.uom.msc20.distributed.formicary.service;

import lk.uom.msc20.distributed.formicary.util.HostDataUtil;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Service
public class StaticDataService {
    private static final Logger logger = LoggerFactory.getLogger(StaticDataService.class);

    private final String nodeId = String.valueOf(UUID.randomUUID());
    private final String hostedIp = HostDataUtil.getCurrentHostedIp();
    private final String hostName = HostDataUtil.getCurrentHostName();
    private Instant started;
    @Value("${server.port}")
    private String serverPort;
    @Value("${timeout.file.search}")
    private long searchTimeout;
    @Value("${bootstrap.server.url}")
    private String bootstrapServer;


}
