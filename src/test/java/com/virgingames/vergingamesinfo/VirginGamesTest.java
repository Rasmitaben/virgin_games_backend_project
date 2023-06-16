package com.virgingames.vergingamesinfo;

import com.virgingames.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasValue;
@RunWith(SerenityRunner.class)

public class VirginGamesTest extends TestBase {

    @Steps
    VirginGamesSteps virginGamesSteps;

    @Title("This Method will get all Jackpot information")
    @Test
    public void test001(){
        virginGamesSteps.getAllJackpotsInfo().statusCode(200).log().all();
    }

    @Title("This method will verify if currency is equal to GBP")
    @Test
    public void test002(){
     ValidatableResponse response = virginGamesSteps.getAllJackpotsInfo();
        HashMap<String,Object> gamesMap = response.extract().path("data.pots[0]");
        System.out.println("List" + gamesMap);
        Assert.assertThat(gamesMap,hasValue("GBP"));
    }
    @Title("This method will verify jackpot Id = Bingo")
    @Test
    public void test003(){
        ValidatableResponse response = virginGamesSteps.getAllJackpotsInfo();
        response.statusCode(200).log().ifValidationFails();
        response.body("data.jackpotId", equalTo("Bingo"));
    }

}
