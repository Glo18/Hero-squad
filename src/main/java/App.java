import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroform", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "heroform.hbs");
        }, new HandlebarsTemplateEngine());

        post("/new/hero", (request, response) -> {

            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            Hero  newHero = new Hero(name,age,power,weakness);
            request.session().attribute("item",name);
            model.put("item",request.session().attribute("item"));
            model.put("newHero",newHero);
            return new ModelAndView(model, "successhero.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> hero = (ArrayList<Hero>) Hero.getAll();
            model.put("hero",hero);
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squadform", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squadform.hbs");
        }, new HandlebarsTemplateEngine());

        post("/success", (request, response) -> {

            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            int size = Integer.parseInt(request.queryParams("size"));
            String cause = request.queryParams("cause");

            Squad squad = new Squad(name,size,cause);

            model.put("squad", squad);
            return new ModelAndView(model, "successSquad.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("squad", Squad.getMembers());
            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());
    }
}

