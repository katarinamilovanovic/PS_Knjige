/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Autor;
import model.Knjiga;
import model.Zanr;

/**
 *
 * @author kmilo
 */
public class DBBroker {

    public List<Knjiga> ucitajListuKnjigaIzBaze() {
        List<Knjiga> listaKnjiga = new ArrayList<>();
        try {

            String upit = "SELECT * FROM knjiga k JOIN autor a ON k.AutorID = a.ID";
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                int idK = rs.getInt("ID");
                String naslov = rs.getString("Naslov");
                int godinaIzdanja = rs.getInt("godinaIzdanja");
                String ISBN = rs.getString("ISBN");
                String z = rs.getString("Zanr");
                Zanr zanr = Zanr.valueOf(z);

                int idA = rs.getInt("a.ID");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                int godinaRodjenja = rs.getInt("godinaRodjenja");
                String biografija = rs.getString("biografija");

                Autor a = new Autor(idA, ime, prezime, godinaRodjenja, biografija);
                Knjiga k = new Knjiga(idK, naslov, a, ISBN, godinaIzdanja, zanr);

                listaKnjiga.add(k);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaKnjiga;
    }

    public List<Autor> ucitajListuAutoraIzBaze() {
        List<Autor> listaAutora = new ArrayList<>();

        try {
            String upit = "SELECT * FROM autor";
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);

            while (rs.next()) {
                int id = rs.getInt("ID");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String biografija = rs.getString("biografija");
                int godinaRodjenja = rs.getInt("godinaRodjenja");

                Autor a = new Autor(id, ime, prezime, godinaRodjenja, biografija);
                listaAutora.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaAutora;
    }

    public void obrisiKnjiguIzBaze(int id) {
        try {
            //String upit = "DELETE FROM knjiga WHERE ID = "+id;
            String upit = "DELETE FROM knjiga WHERE ID = ?";
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setInt(1, id);
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dodajKnjiguUBazu(Knjiga novaKnjiga) {
        try {
            String upit = "INSERT INTO knjiga(id, naslov, autorID, ISBN, godinaIzdanja, zanr) VALUES(?,?,?,?,?,?) ";
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setInt(1, novaKnjiga.getID());
            ps.setString(2, novaKnjiga.getNaslov());
            ps.setInt(3, novaKnjiga.getAutor().getID());
            ps.setString(4, novaKnjiga.getISBN());
            ps.setInt(5, novaKnjiga.getGodinaIzdanja());
            ps.setString(6, String.valueOf(novaKnjiga.getZanr()));
            
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void azurirajKnjigu(Knjiga knjigaZaIzmenu) {
        try {
            String upit = "UPDATE knjiga SET Naslov=?, AutorID =?, godinaIzdanja = ?, Zanr = ? WHERE ID = ?";
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            
            ps.setString(1, knjigaZaIzmenu.getNaslov());
            ps.setInt(2, knjigaZaIzmenu.getAutor().getID());
            ps.setInt(3, knjigaZaIzmenu.getGodinaIzdanja());
            ps.setString(4, String.valueOf(knjigaZaIzmenu.getZanr()));
            ps.setInt(5, knjigaZaIzmenu.getID());
            
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean login2(String username, String password) {
        try {
            String upit = "SELECT * FROM user WHERE username = ? and password = ?";
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
