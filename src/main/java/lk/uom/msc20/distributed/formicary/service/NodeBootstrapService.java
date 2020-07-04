package lk.uom.msc20.distributed.formicary.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class NodeBootstrapService {

    private static final Logger logger = LoggerFactory.getLogger(NodeBootstrapService.class);

    final StaticDataService staticDataService;

    public NodeBootstrapService(StaticDataService staticDataService) {
        this.staticDataService = staticDataService;
    }

    /**
     * Establish connection to the Bootstrap server
     *
     * @return status of the registering
     */
    public boolean register() {
        logger.info("Registering node to the Bootstrap server " + staticDataService.getNodeId());
        //TODO register to the Bootstrap server

        //set started time to now. Ned to use UTC
        staticDataService.setStarted(Instant.now());
        return true;
    }
}
