package lk.uom.msc20.distributed.formicary.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Node {
    private String ip;
    //to calculate up time
    private String started;
    private String timeTakenForSearchResult;
}
