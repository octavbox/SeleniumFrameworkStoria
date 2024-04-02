package UtilityClasses;

import java.text.Normalizer;

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

    public static String removeDiacriticsFromAll(String text){
        return Normalizer.normalize(text, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
    }

}
