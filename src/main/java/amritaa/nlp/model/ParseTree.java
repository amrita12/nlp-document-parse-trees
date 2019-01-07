package amritaa.nlp.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Author amrita12
 */
@Builder
@Data
@ToString
public class ParseTree {
    List<Node> nodes;
}
