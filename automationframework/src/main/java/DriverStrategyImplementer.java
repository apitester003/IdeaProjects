public class DriverStrategyImplementer {
    public static DriverStrategy chooseStrategy(char strategy) {
        switch(strategy){
            case 'C': //case "Chrome":
                return new Chrome();

            case 'P': //case "PhantomJS":
                return new PhantomJS();

            case 'F': //case "Firefox":
                return new Firefox();

            default:
                return null;
        }
    }
}
