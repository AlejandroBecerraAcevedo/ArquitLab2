package udea.edu.co.lab2;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import java.util.Locale;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class DataController {

    @GetMapping("/")
    public String healthCheck() {

        return "APLICACION FUNCIONANDO OK!";

    }

    @GetMapping("/version")
    public String version() {

        return "La version Actual es 1.0.0";

    }

    @GetMapping("/nations")
    public JsonNode getRandomNations() {

        var objectMapper = new ObjectMapper();
        @SuppressWarnings("deprecation")
        var faker = new Faker(new Locale("en-US"));
        var nations = objectMapper.createArrayNode();

        for (var i = 0; i < 10; i++) {

            var nation = faker.nation();

            nations.add(objectMapper.createObjectNode()

                    .put("nationality", nation.nationality())
                    .put("capitalCity", nation.capitalCity())
                    .put("flag", nation.flag())
                    .put("language", nation.language()));

        }

        return nations;

    }

    @GetMapping("/currencies")
    public JsonNode getRandomCurrencies() {

        var objectMapper = new ObjectMapper();

        @SuppressWarnings("deprecation")
        var faker = new Faker(new Locale("en-US"));

        var currencies = objectMapper.createArrayNode();

        for (var i = 0; i < 10; i++) {

            var currency = faker.currency();

            currencies.add(objectMapper.createObjectNode()

                    .put("name", currency.name())
                    .put("code", currency.code()));

        }

        return currencies;

    }

    @GetMapping("/airlines")
    public JsonNode getRandomAirlines() {

        var objectMapper = new ObjectMapper();

        @SuppressWarnings("deprecation")
        var faker = new Faker(new Locale("en-US"));

        var airlines = objectMapper.createArrayNode();

        for (var i = 0; i < 20; i++) {

            var aviation = faker.aviation();

            airlines.add(objectMapper.createObjectNode()

                    .put("aircraft", aviation.aircraft())
                    .put("airport", aviation.airport())
                    .put("METAR", aviation.METAR()));

        }

        return airlines;

    }

}