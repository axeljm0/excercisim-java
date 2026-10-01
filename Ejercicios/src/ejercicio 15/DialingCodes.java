import java.util.HashMap;
import java.util.Map;

public class DialingCodes {

    private final Map<Integer, String> codes = new HashMap<>();

    public Map<Integer, String> getCodes() {
        return codes;
    }

    public void setDialingCode(int dialingCode, String country) {
        codes.put(dialingCode, country);
    }

    public String getCountry(int dialingCode) {
        return codes.get(dialingCode);
    }

    public void addNewDialingCode(int dialingCode, String country) {
        if (!codes.containsKey(dialingCode) && !codes.containsValue(country)) {
            codes.put(dialingCode, country);
        }
    }

    public Integer findDialingCode(String country) {
        for (Map.Entry<Integer, String> entry : codes.entrySet()) {
            if (entry.getValue().equals(country)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void updateCountryDialingCode(int newDialingCode, String country) {
        Integer oldDialingCode = findDialingCode(country);
        if (oldDialingCode != null) {
            codes.remove(oldDialingCode);
            codes.put(newDialingCode, country);
        }
    }

    public static void main(String[] args) {
        DialingCodes dialingCodes = new DialingCodes();

        System.out.println(dialingCodes.getCodes());

        dialingCodes.setDialingCode(679, "Unknown");
        System.out.println(dialingCodes.getCodes());

        dialingCodes.setDialingCode(679, "Fiji");
        System.out.println(dialingCodes.getCodes());

        dialingCodes.setDialingCode(55, "Brazil");
        System.out.println(dialingCodes.getCountry(55));

        dialingCodes.addNewDialingCode(32, "Belgium");
        dialingCodes.addNewDialingCode(379, "Vatican City");
        System.out.println(dialingCodes.getCodes());

        dialingCodes.addNewDialingCode(32, "Other");
        dialingCodes.addNewDialingCode(39, "Vatican City");
        System.out.println(dialingCodes.getCodes());

        System.out.println(dialingCodes.findDialingCode("Brazil"));
        System.out.println(dialingCodes.findDialingCode("Unlisted"));

        dialingCodes.setDialingCode(88, "Japan");
        System.out.println(dialingCodes.getCodes());

        dialingCodes.updateCountryDialingCode(81, "Japan");
        System.out.println(dialingCodes.getCodes());

        dialingCodes.updateCountryDialingCode(32, "Mars");
        System.out.println(dialingCodes.getCodes());
    }
}