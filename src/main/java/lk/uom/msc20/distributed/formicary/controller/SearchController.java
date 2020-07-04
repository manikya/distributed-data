package lk.uom.msc20.distributed.formicary.controller;

import lk.uom.msc20.distributed.formicary.model.SearchCriteria;
import lk.uom.msc20.distributed.formicary.model.result.EmptySearchResult;
import lk.uom.msc20.distributed.formicary.model.result.ISearchResult;
import lk.uom.msc20.distributed.formicary.model.result.TimeoutSearchResult;
import lk.uom.msc20.distributed.formicary.service.SearchService;
import lk.uom.msc20.distributed.formicary.service.StaticDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Controller
public class SearchController {
    private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

    private final SearchService searchService;
    private final StaticDataService staticDataService;

    public SearchController(SearchService searchService, StaticDataService staticDataService) {
        this.searchService = searchService;
        this.staticDataService = staticDataService;
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "fileName", required = false, defaultValue = "") String fileName, Model model) {
        ISearchResult searchResult;
        try {
            searchResult = searchService.doFileSearchAsync(
                    SearchCriteria.builder()
                            .searchInput(fileName)
                            .initiatedIp(staticDataService.getHostedIp())
                            .initiatedPort(staticDataService.getServerPort())
                            .build()).get(staticDataService.getSearchTimeout(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException e) {
            //should throw or re interrupt on InterruptedException
            logger.error("Error in search", e);
            searchResult = new EmptySearchResult();
        } catch (TimeoutException e) {
            searchResult = new TimeoutSearchResult();
        }
        model.addAttribute("message", searchResult.getMessage());
        logger.info(searchResult.getMessage());

        return "search";
    }
}
