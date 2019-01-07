package amritaa.nlp.util;

import edu.stanford.nlp.trees.Tree;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author amrita12
 */
@Service
public class ParseTreeUtil {


    public List<Tree> getChilds(Tree tree) {
        return tree.getChildrenAsList();
    }

    public Tree getNounPhrase(Tree tree) {
        Tree root = tree.getChild(0);
        List<Tree> childList = root.getChildrenAsList();
        for(Tree child: childList) {
            if(child.label().value().equals("NP")) {
                System.out.println(child.depth());
                return child;
            }
        }

        return null;
    }

    public List<Tree> nodesAtDepth(Tree tree, int depth) {
        Queue<Tree> queue = new LinkedList<>();
        List<Tree> result = new ArrayList<>();
        queue.add(tree);
        if(tree.depth() > depth) {
            for (int i = 0; i < depth; i++) {
                result.clear();
                while(!queue.isEmpty()) {
                    result.addAll(queue.poll().getChildrenAsList());
                }
                queue.addAll(result);
            }
        }

        return result;
    }

    public Tree getVerbPhrase(Tree tree) {
        Tree root = tree.getChild(0);
        List<Tree> childList = root.getChildrenAsList();

        for(Tree child: childList) {
            if(child.label().value().equals("VP")) {
                return child;
            }
        }
        return null;
    }

    /**
     * Return the sub-ordinate clause from the sentence.
     * @param tree
     * @return
     */
    public List<Tree> getSBAR(Tree tree) {
        List<Tree> childList = tree.getChildrenAsList();
        List<Tree> output = new ArrayList<>();
        for(Tree sbar : childList) {
            if(sbar.label().value().equalsIgnoreCase("SBAR")) {
                output.add(sbar);
            }
        }

        return output;
    }

    public Tree getNounPhraseFromVerbPhrase(Tree tree) {

        List<Tree> childPhrases = tree.getChildrenAsList();
        for(Tree childPhrase :  childPhrases) {
            System.out.println(childPhrase);
        }
        return null;
    }
}
