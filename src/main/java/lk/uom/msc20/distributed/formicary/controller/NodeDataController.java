package lk.uom.msc20.distributed.formicary.controller;

import lk.uom.msc20.distributed.formicary.service.StaticDataService;
import lk.uom.msc20.distributed.formicary.util.TimeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NodeDataController {

    private final StaticDataService staticDataService;

    public NodeDataController(StaticDataService staticDataService) {
        this.staticDataService = staticDataService;
    }

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("NodeId", staticDataService.getNodeId());
        model.addAttribute("HostIp", staticDataService.getHostedIp());
        model.addAttribute("HostPort", staticDataService.getServerPort());
        model.addAttribute("HostName", staticDataService.getHostName());
        model.addAttribute("UpTime", TimeUtil.upTime(staticDataService.getStarted()));

        return "index";
    }
}
