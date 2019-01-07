package amritaa.nlp.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Author amrita12
 */
@Data
@Builder
@ToString
public class Node {
    private int index;
    private List<Integer> destinationIndex;
    private String label;
    private boolean isLeaf;
}

