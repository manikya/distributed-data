package lk.uom.msc20.distributed.formicary.model.result;

public class TimeoutSearchResult implements ISearchResult{
    @Override
    public String getMessage() {
        return "Search Result Timeout";
    }
}
