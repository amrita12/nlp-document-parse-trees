$( document ).ready(function() {

    // Create the input graph

    var nodes =  parseTree[0].nodes;

    var g = new dagreD3.graphlib.Graph()
    .setGraph({})
    .setDefaultEdgeLabel(function() { return {}; });

    for(var i=0; i<nodes.length; i++) {
        var destIndex = nodes[i].destinationIndex;
        if(destIndex == null) {
            g.setNode(nodes[i].index,  { label: nodes[i].label,       class: "type-TK" });
        } else {
            g.setNode(nodes[i].index,  { label: nodes[i].label,       class: "type-TOP" });
            for(var j=0; j<destIndex.length; j++) {
               g.setEdge(nodes[i].index, destIndex[j]);
            }

        }

    }

    // Here we"re setting nodeclass, which is used by our custom drawNodes function
    // below.

    g.nodes().forEach(function(v) {
    var node = g.node(v);
    // Round the corners of the nodes
    node.rx = node.ry = 5;
    });

    // Set up edges, no special attributes.

    // Create the renderer
    var render = new dagreD3.render();

    // Set up an SVG group so that we can translate the final graph.
    var svg = d3.select("svg"),
    svgGroup = svg.append("g");

    // Run the renderer. This is what draws the final graph.
    render(d3.select("svg g"), g);

    // Center the graph
    var xCenterOffset = (svg.attr("width") - g.graph().width) / 2;
    svgGroup.attr("transform", "translate(" + xCenterOffset + ", 20)");
    svg.attr("height", g.graph().height + 40);
});
