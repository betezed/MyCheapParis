package com.mycheapparis.app.adapter;

import com.google.gson.*;
import com.mycheapparis.app.model.Address;
import com.mycheapparis.app.model.Cafe;
import com.mycheapparis.app.model.LocationEntry;

import java.lang.reflect.Type;
import java.sql.Timestamp;

/**
 * Created by betezed on 25/11/14.
 */
public class CafeAdapter implements JsonDeserializer<Cafe> {
    @Override
    public Cafe deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        /*
         * L'adapter parse le json pour trouver les éléments qui l'intéressent
         */
        JsonObject deserialize = jsonElement.getAsJsonObject();
        double latitude = 0;
        double longitude = 0;

        try {
            latitude = deserialize.get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray().get(1).getAsDouble();
            longitude = deserialize.get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray().get(0).getAsDouble();
        } catch (Exception e) {
            System.out.println("Null geo datas for the record id : " + deserialize.get("recordid").getAsString());
        }
        java.util.Date date= new java.util.Date();
        LocationEntry locationEntry = new LocationEntry(latitude, longitude, new Timestamp(date.getTime()));
        String zipCode = deserialize.get("fields").getAsJsonObject().get("arrondissement").getAsString();
        String city = "Paris";
        String street = deserialize.get("fields").getAsJsonObject().get("adresse").getAsString();
        String name = deserialize.get("fields").getAsJsonObject().get("nom").getAsString();
        double cafePrice = 1;
        if (deserialize.get("fields").getAsJsonObject().has("prix_comptoir"))
            cafePrice = deserialize.get("fields").getAsJsonObject().get("prix_comptoir").getAsDouble();
        /*
         * Une fois que toutes les données sont récoltées, on instancie l'objet Cafe et on le retourne
         */
        Cafe cafe = new Cafe(name, cafePrice, locationEntry, new Address(street, zipCode, city));
        return cafe;
    }
}
