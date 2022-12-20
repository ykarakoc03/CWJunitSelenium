package Day6_Dropdown_SeleniumWaits;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C01_Faker {

    //Faker değerler üretmek için Faker Class dan obj üretir ve var olan method ları kullanırız


    @Test
    public void fakerExample(){

        Faker faker= new Faker();

        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.address().fullAddress());



    }



}
