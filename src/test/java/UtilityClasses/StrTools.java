package UtilityClasses;

public class StrTools {
    public static String replaceSpaceWithNBSP(String text){
        return text.replaceAll(" ","\u00A0"); //\u00A0 = &nbsp;
    }

    public static String removeDiacriticsFromST(String text){
        return text.replaceAll("ș","s").replaceAll("ț","t");
    }

    public static String makeFirstCharLowerCase(String text){
        String modifiedText = Character.toLowerCase(text.charAt(0)) + text.substring(1);
        return modifiedText;
    }

    //            modifiedCity = Normalizer.normalize(city, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
}
