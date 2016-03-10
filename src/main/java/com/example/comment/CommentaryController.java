package com.example.comment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by thoma on 03/04/16.
 */

@Controller
@RequestMapping("/comments")
public class CommentaryController {

    @RequestMapping(method = RequestMethod.GET, headers = {"content-type=application/json"})
    public
    @ResponseBody
    ResponseEntity<List<Commentary>> getComments() {

        List<Commentary> comments = new ArrayList<>();
        comments.add(new Commentary("Leo", "Toivonen", 4, "Trés bonne expérience."));
        comments.add(new Commentary("Jeanne", "Morel", 5, "Trés bon moment en compagnie de cette personne, la route fu des plus agréables."));
        comments.add(new Commentary("Adam", "Renaud", 2, "Je ne recommenderais pas ce conducteur, convivial mais conduite à risque."));
        comments.add(new Commentary("Penny", "Roger", 3, "Voyage agréable"));
        comments.add(new Commentary("Luna", "Dumont", 1, "La note parle d'elle-même."));
        comments.add(new Commentary("Bill", "Gates", 2, "Le voyage en twingo a été trés désagréable, pourquoi voyager dans de tel voiture de pauvres ?"));
        comments.add(new Commentary("Benjamin", "Gaillard", 3, "Moitié bien, moitié pas bien."));
        comments.add(new Commentary("Luca", "Clark", 4, "Trés convivial et toujours à l'heure."));
        comments.add(new Commentary("Eva", "Back", 4, "Je suis convaincu par ce conducteur, sa conduite est exemplaire et je suis quand même arrivé à l'heure."));
        comments.add(new Commentary("Samu", "Lassila", 5, "Rien a redire."));
        comments.add(new Commentary("Sebastien", "Newman", 2, "Le trajet a été trés génant, pas convivial du tout, mais je suis tout de même arrivé à l'heure."));

        long seed = System.nanoTime();
        Collections.shuffle(comments, new Random(seed));

        return new ResponseEntity<List<Commentary>>(comments.subList(0, 5), HttpStatus.OK);
    }
}
