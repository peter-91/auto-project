import org.testng.annotations.DataProvider;



class DataProviderClass {

    @DataProvider(name = "authentication")

    public static Object[][] credentials() {

        return new Object[][] { { "p.sasnik@gmail.com", "Tunein123" }, { "tunein.user125@gmail.com", "Tunein123" }};

    }

}
