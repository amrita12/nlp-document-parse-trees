# nlp-document-parse-trees
This is utlity to draw the [parse tree](https://en.wikipedia.org/wiki/Parse_tree) of a sentence.
It is a spring boot application which uses Stanford Core NLP to generate the parse tree and Dagger D3 for rendering the graph.

## What is provides?
Visualization of a parse tree is important while debugging NLP systems.
This application provides full integration between client and server to render parse tree for any sentence. This implementation is very much tied to the technologies (Core NLP and D3) js.

## Setup instructions
One need to clone this repository and Download the Core NLP model jar.
Core NLP models jar needs to be put into the lib directory.
After that once you run `gradle bootrun ` you can access the page on localhost.



