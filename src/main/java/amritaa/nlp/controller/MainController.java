package amritaa.nlp.controller;

import amritaa.nlp.model.ParseTree;
import amritaa.nlp.service.ParseTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    ParseTreeService parseTreeService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("msg","NLP Tree");
        return "home";
    }

    @PostMapping("/")
    public String resultPage(@ModelAttribute("inputText")String inputText, Model model) {

        List<ParseTree> parseTree = parseTreeService.getParseTree(inputText);
        model.addAttribute("parseTree", parseTree);

        return "results";
    }
}
