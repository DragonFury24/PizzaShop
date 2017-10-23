public class StringUtils {

    private static StringBuilder temp = new StringBuilder();
    private static String[] temps = null;

    public static String capitalizeWords(String s) {
        temp = new StringBuilder();
        if (s.contains(" ")) {
            temps = s.split(" ");
            for (int i = 0; i < temps.length; i++)
                temps[i] = temps[i].substring(0, 1).toUpperCase() + temps[i].substring(1, temps[i].length());
            for (String tempString : temps)
                temp.append(tempString).append(" ");
            return temp.toString().trim();
        }
        temp.append(s.substring(0, 1).toUpperCase()).append(s.substring(1, s.length()));
        return temp.toString().trim();
    }

}
