/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import baza.DBBroker;
import java.util.ArrayList;
import java.util.List;
import model.Autor;
import model.Knjiga;
import model.User;
import model.Zanr;

/**
 *
 * @author kmilo
 */
public class Controller {

    private DBBroker dbb;

    private List<Knjiga> listaKnjiga = new ArrayList<>();
    private List<Autor> listaAutora = new ArrayList<>();
    private List<User> listaKorisnika = new ArrayList<>();

    public List<Knjiga> getListaKnjiga() {
        return listaKnjiga;
    }

    public void setListaKnjiga(List<Knjiga> listaKnjiga) {
        this.listaKnjiga = listaKnjiga;
    }

    public List<Autor> getListaAutora() {
        return listaAutora;
    }

    public void setListaAutora(List<Autor> listaAutora) {
        this.listaAutora = listaAutora;
    }

    public List<User> getListaKorisnika() {
        return listaKorisnika;
    }

    public void setListaKorisnika(List<User> listaKorisnika) {
        this.listaKorisnika = listaKorisnika;
    }

    private static Controller instance;

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    private Controller() {

        dbb = new DBBroker();

        User u1 = new User(1, "katarina", "katarina");
        User u2 = new User(2, "marko", "marko");
        User u3 = new User(3, "vera", "vera");

        listaKorisnika.add(u1);
        listaKorisnika.add(u2);
        listaKorisnika.add(u3);

        /* Autor autor1 = new Autor("Ivo", "Andric", 1897, "Biografija auora Ive Andrica");
    Autor autor2 = new Autor("Danilo", "Kis", 1935, "Biografija auora Danila Kisa");
    Autor autor3 = new Autor("Mesa", "Selimovic", 1910, "Biografija auora Mese Selimovica");

    
    Knjiga knjiga1 = new Knjiga("Na Drini cuprija", autor1, "123456789", 1945, Zanr.ISTORIJSKI);
    Knjiga knjiga2 = new Knjiga("Basta, pepeo", autor2, "987654321", 1985,Zanr.DETEKTIVSKI );
    Knjiga knjiga3 = new Knjiga("Tvrdjava", autor3, "000000000", 1954, Zanr.ROMAN);
    

    listaKnjiga.add(knjiga1);
    listaKnjiga.add(knjiga2);
    listaKnjiga.add(knjiga3);
    
    listaAutora.add(autor1);
    listaAutora.add(autor2);
    listaAutora.add(autor3);
         */
    
    
    }

    public void obrisiKnjigu(int selektovaniRed) {
        listaKnjiga.remove(selektovaniRed);
    }

    public void obrisiKnjiguIzBaze(int id) {
        dbb.obrisiKnjiguIzBaze(id);
    }

    public void dodajKnjigu(Knjiga novaKnjiga) {
        listaKnjiga.add(novaKnjiga);
    }

    public List<Knjiga> ucitajListuKnjigaIzBaze() {
        return dbb.ucitajListuKnjigaIzBaze();
    }

    public List<Autor> ucitajListuAutoraIzBaze() {
        return dbb.ucitajListuAutoraIzBaze();
    }
    
    

    public void dodajKnjiguUBazu(Knjiga novaKnjiga) {
        dbb.dodajKnjiguUBazu(novaKnjiga);
    }

    public void azurirajKnjigu(Knjiga knjigaZaIzmenu) {
        dbb.azurirajKnjigu(knjigaZaIzmenu);
    }

    public boolean login1(String username, String password) {
        for(User u : listaKorisnika){
            if(u.getUsername().equals(username) && u.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public boolean login2(String username, String password) {
       return dbb.login2(username, password);
    }

    

    
}
