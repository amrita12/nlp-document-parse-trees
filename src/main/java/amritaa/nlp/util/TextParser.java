package amritaa.nlp.util;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.trees.Tree;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * This approach is motivated from following documents
 * https://pdfs.semanticscholar.org/baab/8e4eaeef6ed805cbeb64b6b1c9c9b268fc10.pdf
 * http://bdewilde.github.io/blog/2014/09/23/intro-to-automatic-keyphrase-extraction/
 * Created by @amrita12
 *
 * */
@Service
public class TextParser{

    StanfordCoreNLP stanfordCoreNLP;
    Properties props;

    public TextParser() {
        // set up pipeline properties
        props = new Properties();
        // set the list of annotators to run
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,natlog,depparse,coref,quote");
        // set a property for an annotator, in this case the coref annotator is being set to use the neural algorithm
        props.setProperty("coref.algorithm", "neural");
        // props.setProperty("pos.model", "/edu/stanford/nlp/models/pos-tagger/english-left3words/english-left3words-distsim.tagger");

        // build pipeline
        stanfordCoreNLP = new StanfordCoreNLP(props);
    }

    public CoreDocument parseText(String text) {
        // create a document object
        CoreDocument document = new CoreDocument(text);
        // annnotate the document
        stanfordCoreNLP.annotate(document);


        document.sentences().forEach( sentence -> {
            // constituency parse for the second sentence
            Tree constituencyParse = sentence.constituencyParse();
            System.out.println("Example: constituency parse");
            System.out.println(constituencyParse);
            System.out.println();

            // dependency parse for the second sentence
            SemanticGraph dependencyParse = sentence.dependencyParse();
            System.out.println("Example: dependency parse");
            System.out.println(dependencyParse);
            System.out.println();

        });

        return document;
    }
}

