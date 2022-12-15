package Day1_SeleniumMaven;

import org.junit.*;

public class C02_JunitAnnotations {
    //1. Test
    //2. Test
    //3. Test
    //4. Test(geliştirme aşamasında bu nedenle rapora dahil olmasın)

    //Her testimizden önce ve sonra çalışması gereken kod bloklarımız (methotlarımız) var
    // Tum testlerin oncesinde ve sonrasinda calismasi gereken methodlarimiz mevcut.


    //        1. @Test -> Marks a method as a TEST CASE.
//        2. @Before : Runs before EACH @Test annotation.
//        3. @After : Runs after EACH @Test annotation.
//        4. @BeforeClass : Runs before each class only once.
//        5. @AfterClass : Runs after each class only once.
//        6. @Ignore : Skipping a test case.

    @Test
    public void test01() {
        System.out.println("1. Test yapılıyor....");
    }

    @Test
    public void test02() {
        System.out.println("2. Test yapılıyor....");
    }

    @Test
    public void test03() {
        System.out.println("3. Test yapılıyor....");
    }

    @Test
    @Ignore
    public void test04() {
        System.out.println("4. Test geliştirme aşamasında..");
    }

    @Before
    public void beforeEach() {
        System.out.println("Method öncesi kod bloğu çalıştı");
    }

    @After
    public void afterEach() {
        System.out.println("Method sonrası kod bloğu çalıştı");
    }

                         //beforeClass ve AfterClass class öncesi ve sonrası çalıştırılacagı için clastan bagımsızdır
    @BeforeClass         //bu nedenle static olmalı
    public static void beforeAll() {
        System.out.println("Methodların önceside kod bloğu çalıştı");
    }

    @AfterClass
    public static void afterAll() {
        System.out.println("Methodların sonrasında kod bloğu çalıştı");
    }

/*
çıktı:
// bu şekilde yazmamamıza rağmen before ve after nedeni ile Junit çalıştırdı
//örnegin browser açma işlemlerini her bir methot için ayrı ayrı yazmak yerine @Before methodda yazılabilir
//aynı şekilde açılan browserları @After methotu ile bir kere yazarak kapatabiliriz
//@AfterClass en son raporlanma işlemlerini burda çalışabilriz.

çıktı:
Methodların önceside kod bloğu çalıştı
Method öncesi kod bloğu çalıştı
1. Test yapılıyor....
Method sonrası kod bloğu çalıştı
Method öncesi kod bloğu çalıştı
2. Test yapılıyor....
Method sonrası kod bloğu çalıştı
Method öncesi kod bloğu çalıştı
3. Test yapılıyor....
Method sonrası kod bloğu çalıştı

Test ignored.
Methodların sonrasında kod bloğu çalıştı

 */








}
