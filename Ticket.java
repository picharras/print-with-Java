/*
 * Ticket.java
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

import java.awt.*;
import java.awt.print.*;
import javax.swing.JOptionPane;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.Doc;
import javax.print.ServiceUI;
import javax.print.attribute.*;

public class Ticket {
  
  //Ticket attribute content
  private String contentTicket = "VINATERIA {{nameLocal}}\n"+
    "EXPEDIDO EN: {{expedition}}\n"+
    "DOMICILIO CONOCIDO MERIDA, YUC.\n"+
    "=============================\n"+
    "MERIDA, XXXXXXXXXXXX\n"+
    "RFC: XXX-020226-XX9\n"+
    "Caja # {{box}} - Ticket # {{ticket}}\n"+
    "LE ATENDIO: {{cajero}}\n"+
    "{{dateTime}}\n"+
    "=============================\n"+
    "{{items}}\n"+
    "=============================\n"+
    "SUBTOTAL: {{subTotal}}\n"+
    "IVA: {{tax}}\n"+
    "TOTAL: {{total}}\n\n"+
    "RECIBIDO: {{recibo}}\n"+
    "CAMBIO: {{change}}\n\n"+
    "=============================\n"+
    "GRACIAS POR SU COMPRA...\n"+
    "ESPERAMOS SU VISITA NUEVAMENTE {{nameLocal}}\n"+
    "\n"+
    "\n";
    
  //El constructor que setea los valores a la instancia
  Ticket(String nameLocal, String expedition, String box, String ticket, String caissier, String dateTime, String items, String subTotal, String tax, String total, String recibo, String change) {
    this.contentTicket = this.contentTicket.replace("{{nameLocal}}", nameLocal);
    this.contentTicket = this.contentTicket.replace("{{expedition}}", expedition);
    this.contentTicket = this.contentTicket.replace("{{box}}", box);
    this.contentTicket = this.contentTicket.replace("{{ticket}}", ticket);
    this.contentTicket = this.contentTicket.replace("{{cajero}}", caissier);
    this.contentTicket = this.contentTicket.replace("{{dateTime}}", dateTime);
    this.contentTicket = this.contentTicket.replace("{{items}}", items);
    this.contentTicket = this.contentTicket.replace("{{subTotal}}", subTotal);
    this.contentTicket = this.contentTicket.replace("{{tax}}", tax);
    this.contentTicket = this.contentTicket.replace("{{total}}", total);
    this.contentTicket = this.contentTicket.replace("{{recibo}}", recibo);
    this.contentTicket = this.contentTicket.replace("{{change}}", change);
  }
    
  public void print() {
    //Especificamos el tipo de dato a imprimir
    //Tipo: bytes; Subtipo: autodetectado
    DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
    
    //Aca obtenemos el servicio de impresion por defatul
    //Si no quieres ver el dialogo de seleccionar impresora usa esto
    //PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
    
    
    //Con esto mostramos el dialogo para seleccionar impresora
    //Si quieres ver el dialogo de seleccionar impresora usalo
    //Solo mostrara las impresoras que soporte arreglo de bits
    PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
    PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
    PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
    PrintService service = ServiceUI.printDialog(null, 700, 200, printService, defaultService, flavor, pras);
      
    //Creamos un arreglo de tipo byte
    byte[] bytes;

    //Aca convertimos el string(cuerpo del ticket) a bytes tal como
    //lo maneja la impresora(mas bien ticketera :p)
    bytes = this.contentTicket.getBytes();

    //Creamos un documento a imprimir, a el se le appendeara
    //el arreglo de bytes
    Doc doc = new SimpleDoc(bytes,flavor,null);
      
    //Creamos un trabajo de impresión
    DocPrintJob job = service.createPrintJob();

    //Imprimimos dentro de un try de a huevo
    try {
      //El metodo print imprime
      job.print(doc, null);
    } catch (Exception er) {
      JOptionPane.showMessageDialog(null,"Error al imprimir: " + er.getMessage());
    }
  }

}