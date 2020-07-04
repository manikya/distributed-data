package lk.uom.msc20.distributed.formicary.model.result;

public class EmptySearchResult implements ISearchResult {
    @Override
    public String getMessage() {
        return "No Search Results Found";
    }
}
