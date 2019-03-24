package com.tests.sample4_restassured;

import com.artos.annotation.DataProvider;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * <PRE>
 * - Sample test to demonstrate the use of {@code RestAssured} with Artos
 * - testUnit_1 Code demonstrates that user can use given(),when(),then() methods of RestAssured to test Rest API's
 * - testUnit_2 Code demonstrates that user can use given(),when(),then() methods of RestAssured with data provider to test Rest API's
 * </PRE>
 */
@TestPlan(preparedBy = "arpit", preparationDate = "6/03/2019", bdd = "GIVEN PC has internet access AND used websites are not blocked through firewall THEN rest assured API ests should be executed successfully")
@TestCase(sequence = 0)
public class Sample_RestAssured implements TestExecutable {

	@Unit(sequence = 1)
	public void testUnit_1(TestContext context) {
		// --------------------------------------------------------------------------------------------
		given().pathParam("country", "us").pathParam("zipcode", "90210").when().get("http://api.zippopotam.us/{country}/{zipcode}").then()
				.assertThat().statusCode(200).and().contentType(ContentType.JSON);

		// --------------------------------------------------------------------------------------------
	}

	@Unit(sequence = 2, dataprovider = "seasonsAndNumberOfRaces")
	public void testUnit_2(TestContext context) {
		// --------------------------------------------------------------------------------------------
		String season = (String) context.getParameterisedObject1();
		int numberOfRaces = (int) context.getParameterisedObject2();

		context.getLogger().info(season);
		context.getLogger().info(numberOfRaces);

		given().pathParam("raceSeason", season).when().get("http://ergast.com/api/f1/{raceSeason}/circuits.json").then().assertThat()
				.body("MRData.CircuitTable.Circuits.circuitId", hasSize(numberOfRaces));
		// --------------------------------------------------------------------------------------------
	}

	@Unit(sequence = 3)
	public void testUnit_3(TestContext context) {
		// Use of Authentication using RestAssured
		given().auth().preemptive().basic("username", "password").when().get("http://path.to/basic/secured/api").then().assertThat().statusCode(200);
	}

	/**
	 * Data provider method to test an API
	 * 
	 * @param context TestContext object
	 * @return 2D data provider object
	 */
	@DataProvider(name = "seasonsAndNumberOfRaces")
	public Object[][] createTestDataRecords(TestContext context) {
		// @formatter:off
	    return new Object[][] {
	        {"2017",20},
	        {"2016",21},
	        {"1966",9}
	    };
	    // @formatter:on
	}

}
