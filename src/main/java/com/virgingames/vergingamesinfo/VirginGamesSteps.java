package com.virgingames.vergingamesinfo;

import com.virgingames.constants.EndPoints;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class VirginGamesSteps {
    @Step("Getting all games information ")
    public ValidatableResponse getAllJackpotsInfo(){
               return SerenityRest.given()
                       .when()
                       .get(EndPoints.GET_BINGO)
                       .then();
    }
}