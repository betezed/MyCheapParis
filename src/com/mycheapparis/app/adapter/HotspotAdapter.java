package com.mycheapparis.app.adapter;


import com.google.gson.*;
import com.mycheapparis.app.model.Address;
import com.mycheapparis.app.model.Hotspot;
import com.mycheapparis.app.model.LocationEntry;

import java.lang.reflect.Type;
import java.sql.Timestamp;

/**
 * Created by betezed on 25/11/14.
 */
public class HotspotAdapter implements JsonDeserializer<Hotspot> {
    @Override
    public Hotspot deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject deserialize = jsonElement.getAsJsonObject();
        /*
         * L'adapter parse le json pour trouver les éléments qui l'intéressent
         */
        double latitude = deserialize.get("fields").getAsJsonObject().get("geo_coordinates").getAsJsonArray().get(0).getAsDouble();
        double longitude = deserialize.get("fields").getAsJsonObject().get("geo_coordinates").getAsJsonArray().get(1).getAsDouble();
        java.util.Date date= new java.util.Date();
        LocationEntry locationEntry = new LocationEntry(latitude, longitude, new Timestamp(date.getTime()));
        String zipCode = deserialize.get("fields").getAsJsonObject().get("cp").getAsString();
        String city = deserialize.get("fields").getAsJsonObject().get("ville").getAsString();
        String street = deserialize.get("fields").getAsJsonObject().get("adresse").getAsString();
        String name = deserialize.get("fields").getAsJsonObject().get("nom_site").getAsString();
        Hotspot hotspot = new Hotspot(name, locationEntry, new Address(street, zipCode, city));
        /*
         * Une fois que toutes les données sont récoltées, on instancie l'objet Hotspot et on le retourne
         */
        return hotspot;
    }
}
