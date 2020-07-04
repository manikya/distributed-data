package lk.uom.msc20.distributed.formicary;

import lk.uom.msc20.distributed.formicary.service.NodeBootstrapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * This class is added to initialize the node on successful startup
 * Register to boot server
 */

@Component
@Order(0)
public class StartupApplicationListener implements ApplicationListener<ApplicationReadyEvent> {

    private static final Logger logger = LoggerFactory.getLogger(StartupApplicationListener.class);

    private final NodeBootstrapService nodeBootstrapService;

    public StartupApplicationListener(NodeBootstrapService nodeBootstrapService) {
        this.nodeBootstrapService = nodeBootstrapService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        logger.info("Application Ready Event Fired");
        //try to register to the Bootstrap Server
        if (!nodeBootstrapService.register()) {
            //if registration fails then shut down node
            logger.error("Connecting to Bootstrap server failed. Shutting Down Node");
            System.exit(0);
        }
    }
}
