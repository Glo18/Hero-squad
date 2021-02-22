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
    }

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
        Hero newHero = new Hero(name,age,power,weakness);
        request.session().attribute("item",name);
        model.put("item",request.session().attribute("item"));
        model.put("newHero",newHero);
        return new ModelAndView(model, "successhero.hbs");
    }, new HandlebarsTemplateEngine());
}
