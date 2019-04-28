package com.wildcodeschool.surLaRoute.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@Controller
public class DoctorController {

    @RequestMapping("/doctor/{number}")
    @ResponseBody
    public ExtendedDoctor myDoctor(@PathVariable Integer number, @RequestParam (value = "details", required = false) boolean details ){

        if(details == true) {
            switch (number) {
                case 9:
                    return new ExtendedDoctor(number, "Christopher Eccleston", "13", "41");
                case 10:
                    return new ExtendedDoctor(number, "David Tennant", "47", "34");
                case 11:
                    return new ExtendedDoctor(number, "Matt Smith", "44", "27");
                case 12:
                    return new ExtendedDoctor(number, "Peter Capaldi", "40", "55");
                case 13:
                    return new ExtendedDoctor(number, "Jodie Whittaker", "11", "35");
            }
        }

        if(details == false) switch (number) {
            case 9:
                return new ExtendedDoctor(number, "Christopher Eccleston", "", "");
            case 10:
                return new ExtendedDoctor(number, "David Tennant", "", "");
            case 11:
                return new ExtendedDoctor(number, "Matt Smith", "", "");
            case 12:
                return new ExtendedDoctor(number, "Peter Capaldi", "", "");
            case 13:
                return new ExtendedDoctor(number, "Jodie Whittaker", "", "");

        }

        if((number >= 1)&&(number <=8)) {
            throw new ResponseStatusException(HttpStatus.SEE_OTHER);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Impossible de récupérer l'incarnation " + number);
    }

    class Doctor {

        private int number;
        private String name;
        private String numberOfEpisodes;
        private String ageAtStart;

        Doctor(int number, String name, String numberOfEpisodes, String ageAtStart) {
            this.number = number;
            this.name = name;
            this.numberOfEpisodes = numberOfEpisodes;
            this.ageAtStart = ageAtStart;
        }

        public int getNumber() {
            return number;
        }

        public String getName() {
            return name;
        }

        public String getNumberOfEpisodes() {
            return numberOfEpisodes;
        }

        public String getAgeAtStart() {
            return ageAtStart;
        }
    }

    class ExtendedDoctor extends Doctor {


        ExtendedDoctor(int number, String name, String numberOfEpisodes, String ageAtStart) {
            super(number, name, numberOfEpisodes, ageAtStart);
        }
    }
}