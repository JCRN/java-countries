package local.jcrn.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class CountryNameController
{
    // localhost:2019/data/names/all
    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<?> getAllCountries() {
        CountriesApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(CountriesApplication.ourCountryList.countryList, HttpStatus.OK);
    }

    // localhost:2019/data/names/start/{letter}
    @GetMapping(value = "/start/{letter}",
            produces = {"application/json"})
    public ResponseEntity<?> getCountryByFirstLetter(@PathVariable char letter) {
        ArrayList<Country> rtnCountries =
                CountriesApplication.ourCountryList.findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    // localhost:2019/data/names/size/{number}
    @GetMapping( value = "/size/{number}",
            produces = {"application/json"})
    public ResponseEntity<?> getCountriesByNameLength(
            @PathVariable int number)
    {
        ArrayList<Country> rtnCountries = CountriesApplication.ourCountryList
                .findCountries(c -> c.getName().length() >= number);
        rtnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

}

