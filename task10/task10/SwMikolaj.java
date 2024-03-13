import java.lang.reflect.Field;

import java.lang.reflect.Modifier;
import java.util.*;

import static java.lang.Integer.valueOf;

public class SwMikolaj implements Inwentaryzator{

    @Override
    public Map<String, Integer> inwentaryzacja(List<String> listaKlas) {
        Map<String,Integer> pola = new HashMap<>();
        Set<String> nazwy = new HashSet<>(Arrays.asList("bombki", "lancuchy", "cukierki", "prezenty", "szpice", "lampki"));
        for(String klasa: listaKlas)
        {
            try{
                Class<?> clazz = Class.forName(klasa);
                Field[] fields = clazz.getDeclaredFields();
                for(Field field: fields)
                {
                    if(nazwy.contains(field.getName()))
                    {
                        if (!Modifier.isStatic(field.getModifiers()) &&
                                Modifier.isPublic(field.getModifiers()) &&
                                field.getType() == int.class)
                        {
                            Object o = clazz.newInstance();
                            if(!pola.containsKey(field.getName()))
                                pola.put(field.getName(), valueOf(field.getInt(o)));
                            else pola.put(field.getName(), valueOf(pola.get(field.getName()) + field.getInt(o)));
                        }
                    }
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return pola;
    }
}
