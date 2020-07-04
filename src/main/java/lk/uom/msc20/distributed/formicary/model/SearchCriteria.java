package lk.uom.msc20.distributed.formicary.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class SearchCriteria {
    private String searchInput;
    //search initiated location data
    private String initiatedIp;
    private String initiatedPort;
}
