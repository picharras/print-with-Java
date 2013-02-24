/*
 * Ticketera.java
 * 
 * Copyright 2013 Josue Camara <picharras@picharras-HP-Folio>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 */

public class Ticketera {

  public static void main (String args[]) {
    //Aca llenamos los articulos, sustituyelo por lo de tu eleccion
    String items = "2   Articulo Prueba   15.00\n"+
    "7   Articulo Tara tara   25.00\n"+
    "4   Super articulo   55.39";
    String store = "Picharras Ltd.";
    String venue = "Molas, Yuc.";
    String date = "01/enero/2012";
    String caissier = "Josue Camara";
    Ticket ticket = new Ticket(store, venue, "5", "99", caissier, date, items, "100.00", "16.00", "116.00", "150", "34");
  }
}