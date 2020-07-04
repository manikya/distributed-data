package lk.uom.msc20.distributed.formicary.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostDataUtil {
    private HostDataUtil() {
    }

    private static final Logger logger = LoggerFactory.getLogger(HostDataUtil.class);

    public static String getCurrentHostedIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            logger.error("Host cannot be identified", e);
            return "Error in Host Identification";
        }
    }

    public static String getCurrentHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            logger.error("Host cannot be identified", e);
            return "Error in Host Name Identification";
        }
    }


}
