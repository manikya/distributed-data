package lk.uom.msc20.distributed.formicary.service;

import lk.uom.msc20.distributed.formicary.model.SearchCriteria;
import lk.uom.msc20.distributed.formicary.model.result.EmptySearchResult;
import lk.uom.msc20.distributed.formicary.model.result.ISearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * This service contains logic on search
 */

@Service
public class SearchService {
    private final Logger logger = LoggerFactory.getLogger(SearchService.class);

    @Async
    public CompletableFuture<ISearchResult> doFileSearchAsync(SearchCriteria searchCriteria) {
        logger.info("doFileSearchAsync started");
        // TODO add search logic
        return CompletableFuture.completedFuture(new EmptySearchResult());
    }

}
