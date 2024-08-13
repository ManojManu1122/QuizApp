package com.manoj.QuizApp.controller;

import com.manoj.QuizApp.model.Question;
import com.manoj.QuizApp.model.QuestionWrapper;
import com.manoj.QuizApp.model.Response;
import com.manoj.QuizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){

        //return new ResponseEntity<>("All good", HttpStatus.OK); //Used for checking whether url is working properly or not
        return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitAllQuestions(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id,responses);

    }

}
