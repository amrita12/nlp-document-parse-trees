package amritaa.nlp.service;


import amritaa.nlp.model.Node;
import amritaa.nlp.model.ParseTree;
import amritaa.nlp.util.ParseTreeUtil;
import amritaa.nlp.util.TextParser;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.trees.Tree;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author amrita12
 */
@Service
@Setter
public class ParseTreeService {

    @Autowired
    TextParser textParser;

    @Autowired
    ParseTreeUtil parseTreeUtil;

    public List<ParseTree> getParseTree(String inputText) {

        CoreDocument coreDocument = textParser.parseText(inputText);

        List<ParseTree> parseTrees = new ArrayList<>();
        for(CoreSentence sentence: coreDocument.sentences()) {

            parseTrees.add(buildParseTree(sentence.constituencyParse()));
        }
        return parseTrees;
    }


    private ParseTree buildParseTree(Tree tree) {
        Queue<Tree> queue = new LinkedList<>();
        ParseTree parseTree = ParseTree.builder().nodes(new ArrayList<>()).build();


        int nodeIdx = 0;
        int childIdx = 0;
        queue.add(tree);

        while (!queue.isEmpty()) {
            Tree parentTree = queue.poll();
            System.out.println("Parent tree: " + parentTree);

            List<Tree> childs = parseTreeUtil.getChilds(parentTree);
            // All the child nodes will next set of nodeIdx so just start adding them.

            if(parentTree.depth() == 0) {

                Node parent = Node.builder()
                        .index(nodeIdx)
                        .label(parentTree.value())
                        .isLeaf(true)
                        .build();
                parseTree.getNodes().add(parent);
                nodeIdx++;

            } else {

                List<Integer> destinationIndex = new ArrayList<>();
                for (int i = 0; i < childs.size(); i++) {
                    destinationIndex.add(childIdx + 1);
                    childIdx++;
                }

                //Create root node
                Node parent = Node.builder()
                        .index(nodeIdx)
                        .label(parentTree.value())
                        .destinationIndex(destinationIndex)
                        .build();
                parseTree.getNodes().add(parent);
                nodeIdx++;
                queue.addAll(childs);

            }

        }

        return parseTree;
    }
}
