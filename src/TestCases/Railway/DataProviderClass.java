package Railway;

import org.testng.annotations.DataProvider;
public class DataProviderClass {
    @DataProvider(name="BookTicket")
    public static Object[][] getDataFromDataProvider(){
        return new Object[][] {
                { "1/8/2022", "Huế", "Nha Trang", "Soft seat with air conditioner", "1" },
                { "1/10/2022", "Quảng Ngãi", "Đà Nẵng", "Soft bed", "1" }
        };
    }}
