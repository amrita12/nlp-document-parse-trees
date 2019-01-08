# nlp-document-parse-trees
This is utlity to draw the [parse tree](https://en.wikipedia.org/wiki/Parse_tree) of a sentence.
It is a spring boot application which uses Stanford Core NLP to generate the parse tree and Dagger D3 for rendering the graph.

## What it provides?
Visualization of a parse tree is important while debugging NLP systems.
This application provides full integration between client and server to render parse tree for any sentence. This implementation is very much tied to the technologies (Core NLP and D3) js.

### Sample output
![parsetree](https://user-images.githubusercontent.com/9726902/50806057-f58de180-12a9-11e9-8d18-3a4cf2ffbfcc.png)


## Setup instructions
1. One need to clone this repository.
2. Download the [Core NLP model jar](https://stanfordnlp.github.io/CoreNLP/) and copy it into the libs directory.
3. After that once you run `gradle bootrun ` you can access the page on http://localhost:8081/.





