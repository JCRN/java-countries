package local.jcrn.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class CountryPopulationController
{
    // localhost:2019/data/population/size/{people}
    @GetMapping(value = "/size/{people}",
                produces = {"application/json"})
    public ResponseEntity<?> getPopulationBySize(@PathVariable long people) {
        ArrayList<Country> countries =
                CountriesApplication.ourCountryList.findCountries(c-> c.getPopulation() >= people);
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    // localhost:2019/data/population/min
    @GetMapping(value = "/min",
            produces = {"application/json"})
    public ResponseEntity<?> getSmallestPopulation() {

        Country countryMax = CountriesApplication.ourCountryList.countryList.get(0);

        for (Country c: CountriesApplication.ourCountryList.countryList) {
            if (c.getPopulation() < countryMax.getPopulation()) {
                countryMax = c;
            }
        }
        return new ResponseEntity<>(countryMax, HttpStatus.OK);
    }
    // localhost:2019/data/population/max
    @GetMapping(value = "/max",
                produces = {"application/json"})
    public ResponseEntity<?> getLargestPopulation() {

        Country countryMin = CountriesApplication.ourCountryList.countryList.get(0);

        for (Country c: CountriesApplication.ourCountryList.countryList) {
            if (c.getPopulation() > countryMin.getPopulation()) {
                countryMin = c;
            }
        }
        return new ResponseEntity<>(countryMin, HttpStatus.OK);
    }
}
